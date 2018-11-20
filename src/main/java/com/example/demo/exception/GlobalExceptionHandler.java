package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends Throwable {



    @ExceptionHandler(Exception.class)
    @ResponseBody
    private Map errorHandler(HttpServletRequest request,  Exception exception) {

        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", exception.getMessage());
        return map;
    }


}