package cn.lhqs.common;

import java.io.File;
import java.io.FileOutputStream;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-03-24 17:02
 * description : FileUtils.class
 * version : 1.0
 */
public class FileUtils {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
