package com.example.demo.service.impl;

import com.example.demo.model.Orders;
import com.example.demo.respository.OrdersRepository;
import com.example.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    //保存用户
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }
}
