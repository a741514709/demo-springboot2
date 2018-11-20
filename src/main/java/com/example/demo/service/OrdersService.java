package com.example.demo.service;

import com.example.demo.model.Orders;
import com.example.demo.respository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YF-20170911 on 2018/11/19.
 */
@Service
@Transactional
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    //保存用户
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

}
