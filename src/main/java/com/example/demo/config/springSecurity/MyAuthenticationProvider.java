package com.example.demo.config.springSecurity;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;


    //登录安全认证
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal(); // 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials(); // 这个是表单中输入的密码；

        UserDetails userInfo = userService.loadUserByUsername(userName);

        if (!userInfo.getPassword().equals(password)) {
            throw new BadCredentialsException("用户名密码不正确，请重新登陆！");
        }
        return new UsernamePasswordAuthenticationToken(userName, password, userInfo.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
