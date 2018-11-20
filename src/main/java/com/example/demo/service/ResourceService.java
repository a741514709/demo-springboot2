package com.example.demo.service;

import com.example.demo.model.Resource;
import com.example.demo.respository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YF-20170911 on 2018/11/20.
 */
@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource save(Resource resource){
        return resourceRepository.save(resource);
    }
}
