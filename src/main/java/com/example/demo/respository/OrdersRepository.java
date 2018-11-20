package com.example.demo.respository;

import com.example.demo.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YF-20170911 on 2018/11/19.
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {


}
