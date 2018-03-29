package cn.lhqs.controller;

import cn.lhqs.common.*;
import cn.lhqs.model.InsectInfo;
import cn.lhqs.service.InsectInfoService;
import cn.lhqs.test.SpringTest;
import cn.lhqs.test.TestStream;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.Map;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-03-23 22:14
 * description : InsectDiffController.class
 * version : 1.0
 */

@RestController
@RequestMapping(value = "api")
public class InsectDiffController {

    private static Logger logger = LoggerFactory.getLogger(InsectDiffController.class);

    @Resource
    InsectInfoService infoService;

    @GetMapping(value = "/testget")
    public ResponseResult getInsectResult1(@Param("id") String id) {
        InsectInfo insectInfo = infoService.getInsectInfo(Integer.parseInt(id));
        return new ResponseResult(1, "success", insectInfo);
    }

    @GetMapping(value = "/test")
    public ResponseResult getInsectResult1(@Param("id") int id) throws IOException {
        Map<Integer, Result> map =  null;
        map.entrySet().stream().forEach(m -> System.out.println(m.getKey() + " -- " + m.getValue()));
        return new ResponseResult(1, "success", map);
    }



    /**
     * 图片上传接口
     * @param file
     * @return
     */
    @PostMapping(value = "/insect/uploadImage")
    public ResponseResult uploadImage(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            FileUtils.uploadFile(file.getBytes(), "/root/images/", fileName);
        } catch (Exception e) {
            logger.info("exception---->" + e.getMessage());
            return ResponseResult.fail;
        }

        String params = "/root/bingo/test/run.sh /root/images/"+fileName;
        String[] cmds = {"/bin/sh", "-c", params};
        Process pro = null;
        Map<Integer, Result> respMap = null;
        InputStream in = null;
        BufferedReader read = null;
        int lineCount = 0;
        String fileNameResp = TimeTools.dateFormatNow(TimeTools.DATE_TYPE6) + "-insect.log";
        String filePath = File.separator + "root" + File.separator + "imageText" + File.separator + fileNameResp;
        try {
            pro = Runtime.getRuntime().exec(cmds);
            try {
                pro.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return  ResponseResult.fail;
            }
            in = pro.getInputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            read = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = read.readLine()) != null) {
                bufferedWriter.write(line);
                lineCount++;
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
            respMap = infoService.readLineVarFileName(filePath, lineCount - 5);
            respMap.entrySet().stream().forEach(m -> System.out.println(m.getKey() + " -- " + m.getValue()));// temp output
        } catch (IOException e) {
            e.printStackTrace();
            return  ResponseResult.fail;
        } finally {
            try {
                if (read != null) {
                    read.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return  ResponseResult.fail;

            }
        }
        return new ResponseResult(0, "success", respMap);
    }

    /**
     * 本地测试
     * @return
     * @throws IOException
     */
    @GetMapping(value = "testmap")
    public Map<Integer, Result> getMap() throws IOException {
        Map<Integer, Result> respMap = null;
        InputStream in = null;
        BufferedReader read = null;
        int lineCount = 0;
        String filePath = "D:\\workspace\\insect_result.log";
        String newfilePath = "D:\\workspace\\insect_result.log.bak";
        System.out.println(filePath);
        try {
            in = new FileInputStream(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newfilePath));
            read = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = read.readLine()) != null) {
                bufferedWriter.write(line);
                lineCount++;
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedWriter.close();
            respMap = infoService.readLineVarFileName(newfilePath, lineCount - 5);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (read != null) {
                    read.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return respMap;
    }

}
