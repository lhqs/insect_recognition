package cn.lhqs.common;

import java.io.Serializable;

/**
 * author : lhqs
 * description : 通用返回数据格式
 * createTime : 2017-10-24 16:09
 * version : 1.0
 */
/*@JsonInclude(Include.NON_NULL)*/
public class ResponseResult implements Serializable{
    private static final long serialVersionUID = -3100630958373978641L;
    private int code = 0;
    private String message;
    private Object data;
    public static final ResponseResult ok = new ResponseResult(0,"success");
    public static final ResponseResult fail = new ResponseResult(-1,"failure");

    public ResponseResult() {

    }

    public ResponseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
