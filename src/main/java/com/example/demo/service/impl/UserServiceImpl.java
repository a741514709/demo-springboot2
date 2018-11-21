package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl {
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

    //通过用户id获取用户权限
    public List<String> findPermissionById(Integer id){

        return userRepository.findPermissionById(id);
    }

    //列表默认分页查询
    public Map<Long,List<User>> findAllByPageAndSort(int page, int size){

        Map<Long,List<User>> map=new HashMap<>();

        Sort sort=new Sort(Sort.Direction.DESC,"birth");

        PageRequest pageable= PageRequest.of(page,size,sort);

        Page<User> userPage= userRepository.findAll(pageable);


        long count=userPage.getTotalElements();//总记录数

        List<User> users=userPage.getContent();

        map.put(count,users);

        return map;




    }
}
