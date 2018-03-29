package cn.lhqs.common;

import cn.lhqs.model.InsectInfo;
import java.util.Arrays;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-03-24 10:34
 * description : Result.class
 * version : 1.0
 */
public class Result {

    public static final String url = "http://qiniu.lhqs1314.cn/insect/";
    private String[] res;
    private String rate;
    private String info;
    private String descpation;

    public Result(String info,InsectInfo insectInfo) {
        this.info = info;
        int total = insectInfo.getSize();
        String desc = insectInfo.getNameEnglish();
        String str1 = url + info + "/" + desc + "_" + String.format("%03d", (int) (Math.random() * total) + 1) + ".jpeg";
        String str2 = url + info + "/" + desc + "_" + String.format("%03d", (int) (Math.random() * total) + 1) + ".jpeg";
        String str3 = url + info + "/" + desc + "_" + String.format("%03d", (int) (Math.random() * total) + 1) + ".jpeg";
        String[] arr = {str1, str2, str3};
        this.setDescpation(desc);
        this.setRes(arr);
    }

    public String getDescpation() {
        return descpation;
    }

    public void setDescpation(String descpation) {
        this.descpation = descpation;
    }

    public String[] getRes() {
        return res;
    }

    public void setRes(String[] res) {
        this.res = res;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Result{" +
                "res=" + Arrays.toString(res) +
                ", rate='" + rate + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
