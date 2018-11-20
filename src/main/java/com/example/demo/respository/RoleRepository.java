package com.example.demo.respository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);

}
