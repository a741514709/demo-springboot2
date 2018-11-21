package com.example.demo.service;

import com.example.demo.model.Role;

/**
 * Created by YF-20170911 on 2018/11/16.
 */

public interface RoleService {


     Role save(Role role);


     Role findByName(String name);


     Role findById(Integer id);

}
