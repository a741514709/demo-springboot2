package com.example.demo.controller;

import com.example.demo.response.ApiResponse;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import com.example.demo.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("add")
    public ApiResponse<Role> save(@RequestBody Role role){

        roleService.save(role);

        return ResponseHelper.success(null);
    }
}
