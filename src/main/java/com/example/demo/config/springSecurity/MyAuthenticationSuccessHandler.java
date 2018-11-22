package com.example.demo.config.springSecurity;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//登录成功
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        ResponseBody responseBody = new ResponseBody();

        responseBody.setStatus("200");
        responseBody.setMsg("登录成功");

        response.getWriter().write(JSON.toJSONString(responseBody));

    }
}
