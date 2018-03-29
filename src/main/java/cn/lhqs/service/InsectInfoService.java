package cn.lhqs.service;

import cn.lhqs.common.Result;
import cn.lhqs.dao.InsectInfoMapper;
import cn.lhqs.model.InsectInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-03-24 23:32
 * description : InsectInfoService.class
 * version : 1.0
 */
@Service
public class InsectInfoService {

    @Resource
    InsectInfoMapper insectInfoMapper;

    public InsectInfo getInsectInfo(int id){
        return insectInfoMapper.selectByPrimaryKey(id);
    }

    public Map<Integer,Result> readLineVarFileName(String fileName, int lineNumber) throws IOException {
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
                System.out.println("the line content--->" + line);
                String[] split = line.split(" ");
                Result result = null;
                if (split.length == 5) {
                    for (int i = 0; i < split.length; i++) {
                        System.out.println("split[2]=" + split[2]);
                        result = new Result(split[2], insectInfoMapper.selectByPrimaryKey(Integer.parseInt(split[2])));
                        result.setRate(split[4]);
                        System.out.println("the split[2]:" + split[2] + "  the split[4]:" + split[4]);
                    }
                    map.put(++indexs, result);
                }
            }
            line = reader.readLine();
        }
        return map;
    }
}
