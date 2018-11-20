package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
@Service
@Transactional
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){

        return userRepository.save(user);
    }

    //通过用户名精准查询
    public User findByName(String name){
        return userRepository.findByName(name);
    }

    //通过姓名模糊查询
    public List<User> findByNameLike(String name){

        String likeName="%"+name+"%";

        return userRepository.findByNameLike(likeName);
    }

    //通过id获取用户
    public User findById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    //获取指定用户的所有角色
    public Role findRolesByName(String name){
        User user=findByName(name);
        Role role= user.getRole();
        return role;
    }

    //通过id删除用户
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

}
