package com.example.demo.config.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configurable
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;

    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;

    @Autowired
    MyAuthenticationLogoutHandler myAuthenticationLogoutHandler;

    @Autowired
    MyAuthenticationEntryPoint myAuthenticationEntryPoint;




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

                .httpBasic().authenticationEntryPoint(myAuthenticationEntryPoint)

                .and()

                .authorizeRequests()

                .anyRequest()
                .authenticated()// 其他 url 需要身份认证

                .and()
                .formLogin()  //开启登录
                .successHandler(myAuthenticationSuccessHandler) // 登录成功
                .failureHandler(myAuthenticationFailureHandler) // 登录失败
                .permitAll()

                .and()
                .logout()
                .logoutSuccessHandler(myAuthenticationLogoutHandler)
                .permitAll();

        http.exceptionHandling().accessDeniedHandler(myAccessDeniedHandler); // 无权访问 JSON 格式的数据

    }
}
