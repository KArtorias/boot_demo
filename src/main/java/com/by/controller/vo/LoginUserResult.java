package com.by.controller.vo;

public class LoginUserResult {
    private int code;
    private String message;

    public LoginUserResult(){}
    public LoginUserResult(int code, String message) {
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

    @Override
    public String toString() {
        return "LoginUserResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
