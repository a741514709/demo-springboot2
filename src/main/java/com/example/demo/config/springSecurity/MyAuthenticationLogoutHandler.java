package com.example.demo.config.springSecurity;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationLogoutHandler implements LogoutSuccessHandler {



    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        ResponseBody responseBody = new ResponseBody();

        responseBody.setStatus("100");
        responseBody.setMsg("注销成功");


        response.getWriter().write(JSON.toJSONString(responseBody));

    }
}
