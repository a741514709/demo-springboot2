package com.example.demo.service.impl;

import com.example.demo.model.Catagory;
import com.example.demo.respository.CatatoryRepository;
import com.example.demo.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CatatoryRepository catatoryRepository;

    public Catagory save(Catagory catagory){
        return  catatoryRepository.save(catagory);
    }

    public Catagory findById(int id){
        return catatoryRepository.findById(id).orElse(null);
    }
}
