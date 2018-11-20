package com.example.demo.respository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{


    List<User> findByNameLike(String name);


    User findByName(String name);
}
