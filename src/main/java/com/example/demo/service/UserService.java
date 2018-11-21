package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by YF-20170911 on 2018/11/16.
 */

public interface UserService  {

     User save(User user);

    //通过用户名精准查询
     User findByName(String name);

    //通过姓名模糊查询
     List<User> findByNameLike(String name);

    //通过id获取用户
     User findById(Integer id);

    //通过id删除用户
     void deleteUser(Integer id);

    //通过用户id获取用户权限
     List<String> findPermissionById(Integer id);

    //列表默认分页查询
     Map<Long,List<User>> findAllByPageAndSort(int page, int size);

}
