package com.example.demo.config.springSecurity;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//未登录
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {



    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        ResponseBody responseBody = new ResponseBody();

        responseBody.setStatus("000");
        responseBody.setMsg("未登录");

        response.getWriter().write(JSON.toJSONString(responseBody));
    }
}
