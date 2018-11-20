package com.example.demo.controller;

import com.example.demo.response.ApiResponse;
import com.example.demo.response.UserResponseEnum;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
@RestController
@RequestMapping(value="user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("add")
    public ApiResponse<User> save(@RequestBody @Valid User user, BindingResult bindingResult) {

        int i=1/0;

        if (bindingResult.hasErrors()) {
            return new ApiResponse<>(UserResponseEnum.FAIL.getCode(), bindingResult.getFieldError().getDefaultMessage(), null);
        }

        User ResultUser = userService.save(user);

        ApiResponse<User> result = new ApiResponse<>(UserResponseEnum.SUCCESS.getCode(), UserResponseEnum.SUCCESS.getMessage(), ResultUser);

        return result;
    }

    //通过id查询
    @GetMapping("find/{id}")
    public ApiResponse<User> getUserById(@PathVariable("id") Integer id)  {

        User ResultUser = userService.findById(id);

        if (ResultUser != null) {
            return new ApiResponse<User>(UserResponseEnum.SUCCESS.getCode(), UserResponseEnum.SUCCESS.getMessage(), ResultUser);
        }

        return new ApiResponse<User>(UserResponseEnum.NOTFOUNDUSER.getCode(), UserResponseEnum.NOTFOUNDUSER.getMessage(), ResultUser);

    }


    //删除用户
    @GetMapping("del/{id}")
    public ApiResponse<User> save(@PathVariable("id") Integer id, HttpServletRequest request) {

        User user=userService.findById(id);
        if(!StringUtils.isEmpty(user)){
            userService.deleteUser(id);
            return ResponseHelper.success(user);
        }
        else {
            log.error("接口："+request.getRequestURI()+"  错误："+UserResponseEnum.NOTFOUNDUSER.getMessage());
            return new ApiResponse<User>(UserResponseEnum.NOTFOUNDUSER.getCode(), UserResponseEnum.NOTFOUNDUSER.getMessage(), null);
        }

    }
}
