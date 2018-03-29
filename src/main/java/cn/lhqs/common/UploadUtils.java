package cn.lhqs.common;

import cn.lhqs.service.InsectInfoService;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-03-24 22:30
 * description : UploadUtils.class
 * version : 1.0
 */

public class UploadUtils {


    // 文件内容的总行数。
    public  static int getTotalLines(BufferedReader in) throws IOException {
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        return lines;
    }

    public static Map<Integer,Result> readLineVarFile(BufferedReader reader, int lineNumber) throws IOException {

        String line = reader.readLine();
        if (lineNumber < 0 ) {
            System.out.println("不在文件的行数范围之内。");
        }
        int num = 0;
        Map<Integer,Result> map = new LinkedHashMap<>();
        int indexs = 0;
        while (line != null) {
            if (lineNumber <= ++num) {
                String[] split = line.split(" ");
                Result result = null;
                if(split.length == 5){
                    for(int i = 0; i < split.length; i++){
                        InsectInfoService infoService = new InsectInfoService();
                        result = new Result(split[2],infoService.getInsectInfo(Integer.parseInt(split[2])));
                        result.setRate(split[4]);
                    }
                    map.put(++indexs,result);
                }
            }
            line = reader.readLine();
        }
        return map;
    }

    public static Map<Integer,Result> readLineVarFileName(String fileName, int lineNumber) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName)));
        String line = reader.readLine();
        if (lineNumber < 0) {
            System.out.println("不在文件的行数范围之内。");
        }
        int num = 0;
        Map<Integer, Result> map = new LinkedHashMap<>();
        int indexs = 0;
        while (line != null) {
            if (lineNumber <= ++num) {
                String[] split = line.split(" ");
                Result result = null;
                if (split.length == 5) {
                    for (int i = 0; i < split.length; i++) {
                        InsectInfoService infoService = new InsectInfoService();
                        result = new Result(split[2],infoService.getInsectInfo(Integer.parseInt(split[2])));
                        result.setRate(split[4]);
                    }
                    map.put(++indexs, result);
                }
            }
            line = reader.readLine();
        }
        return map;
    }


}
