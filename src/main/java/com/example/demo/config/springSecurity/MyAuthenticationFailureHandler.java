package com.example.demo.config.springSecurity;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {



    @Override
    public void onAuthenticationFailure(HttpServletRequest request , HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        ResponseBody responseBody = new ResponseBody();

        responseBody.setStatus("400");
        responseBody.setMsg("登录失败，用户名或密码错误");

        response.getWriter().write(JSON.toJSONString(responseBody));
    }
}
