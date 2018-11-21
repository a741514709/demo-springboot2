package com.example.demo.service;

import com.example.demo.model.Catagory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YF-20170911 on 2018/11/20.
 */
@Service
@Transactional
public interface CatagoryService {

     Catagory save(Catagory catagory);

     Catagory findById(int id);
}
