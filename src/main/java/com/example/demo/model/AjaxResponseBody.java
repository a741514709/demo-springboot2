package com.example.demo.model;


import lombok.Data;

@Data
public class AjaxResponseBody {

    private String status;
    private String msg;
    private Object result;
    private String jwtToken;
}
