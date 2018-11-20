package com.example.demo.respository;

import com.example.demo.model.Large;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YF-20170911 on 2018/11/20.
 */
@Repository
public interface LargeRepository extends JpaRepository<Large,Integer> {

}
