package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.respository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl {

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role){

        return roleRepository.save(role);

    }


    public Role findByName(String name){
        return roleRepository.findByName(name);
    }


    public Role findById(Integer id){
        return  roleRepository.findById(id).orElse(null);
    }
}
