package com.trump.enmu;

/**
 * Created by Administrator on 2017/9/13.
 */
public enum ErrorCode {
    SERVER_UNNORMAL_ERROR(-1, "服务器错误"),
    SERVER_NULL_PARAM(201, "缺少参数");

    private int code;
    private String message;

    ErrorCode() {
    }

    ErrorCode(int code, String message) {
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
}
