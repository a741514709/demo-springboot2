package com.example.demo.service;

import com.example.demo.model.Catagory;
import com.example.demo.respository.CatatoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YF-20170911 on 2018/11/20.
 */
@Service
@Transactional
public class CatagoryService {

    @Autowired
    private CatatoryRepository catatoryRepository;

    public Catagory save(Catagory catagory){
        return  catatoryRepository.save(catagory);
    }

    public Catagory findById(int id){
        return catatoryRepository.findById(id).orElse(null);
    }
}
