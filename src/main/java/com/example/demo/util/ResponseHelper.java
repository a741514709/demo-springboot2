package com.example.demo.util;

import com.example.demo.response.ApiResponse;
import com.example.demo.response.UserResponseEnum;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
public class ResponseHelper{

    public static ApiResponse success(Object obj){

        return new ApiResponse<>(UserResponseEnum.SUCCESS.getCode(), UserResponseEnum.SUCCESS.getMessage(),obj);
    }

    public static ApiResponse fail(Object obj){

        return new ApiResponse<>(UserResponseEnum.FAIL.getCode(), UserResponseEnum.FAIL.getMessage(),obj);
    }



}
