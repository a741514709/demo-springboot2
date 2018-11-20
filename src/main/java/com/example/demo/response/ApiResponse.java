package com.example.demo.response;

/**
 * Created by YF-20170911 on 2018/11/16.
 */

import lombok.Data;

@Data
public class ApiResponse<T> {

    private int code;
    private String msg;
    private T data;

    public ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }




}
