package cn.lhqs.test;

import cn.lhqs.common.Result;
import cn.lhqs.common.UploadUtils;
import cn.lhqs.controller.InsectDiffController;
import cn.lhqs.model.InsectInfo;
import cn.lhqs.service.InsectInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;
import java.util.Map;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-03-26 14:52
 * description : SpringTest.class
 * version : 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

    @Resource
    InsectInfoService infoService;
    @Resource
    InsectDiffController insectDiffController;

    public Map<Integer, Result> getMap() throws IOException {
        /*String filePath = "D:\\workspace\\insect_result.log";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath+".bak"));
        InputStream in = new FileInputStream(new File(filePath));
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        String line = null;
        int lineCount = 0;
        Map<Integer,Result> respMap = null;
        while ((line = read.readLine()) != null) {
            bufferedWriter.write(line);
            lineCount++;
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        System.out.println("the lines --> "+lineCount);
        respMap = UploadUtils.readLineVarFileName(filePath, lineCount);

        respMap.entrySet().stream().forEach( m -> System.out.println(m.getKey()+ " -- "+m.getValue()));*/

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
            respMap.entrySet().stream().forEach(m -> System.out.println(m.getKey() + " -- " + m.getValue()));
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

    @Test
    public void spring01() throws IOException {
        SpringTest s =new SpringTest();
        final Map<Integer, Result> map = s.getMap();
        map.entrySet().stream().forEach(m -> System.out.println(m.getKey() + " -- " + m.getValue()));
    }


}
