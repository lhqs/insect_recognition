package cn.lhqs.test;

import cn.lhqs.common.*;

import java.io.*;
import java.util.Map;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-03-26 14:15
 * description : TestStream.class
 * version : 1.0
 */

public class TestStream {
    public static Map<Integer, Result> getMap() throws IOException {
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
            System.out.println("the lines --> "+lineCount);
            respMap = UploadUtils.readLineVarFileName(newfilePath, lineCount - 5);
            respMap.entrySet().stream().forEach( m -> System.out.println(m.getKey()+ " -- "+m.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(read != null  ){
                    read.close();
                }
                if( in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return respMap;
        // String params = "/root/bingo/test/run.sh /root/222.jpg";
        // String[] cmds = {"/bin/sh", "-c", params};
        /*String cmds = "cmd /c dir";
        Process pro = null;
        Map<Integer, Result> respMap = null;
        InputStream in = null;
        BufferedReader read = null;
        try {
            pro = Runtime.getRuntime().exec(cmds);
            try {
                pro.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            in = pro.getInputStream();
            read = new BufferedReader(new InputStreamReader(in));

            int totalLines = UploadUtils.getTotalLines(read);
            respMap = UploadUtils.readLineVarFile(read, totalLines);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseResult.fail;
        } finally {
            try {
                if(read != null  ){
                    read.close();
                }
                if( in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }*/
        // return new ResponseResult(0, "success", respMap);
    }


}
