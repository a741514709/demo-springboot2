package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.respository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role){

        return roleRepository.save(role);

    }


    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
