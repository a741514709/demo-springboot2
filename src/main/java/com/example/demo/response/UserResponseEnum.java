package com.example.demo.response;

/**
 * Created by YF-20170911 on 2018/11/16.
 */

public enum UserResponseEnum {

    SUCCESS(200,"请求成功"),FAIL(500,"请求失败"),NOTFOUNDUSER(100,"查询的用户不存在");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private UserResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
