package com.example.demo.config.springSecurity;


import lombok.Data;

@Data
public class ResponseBody {

    private String status;
    private String msg;
    private Object result;


}
