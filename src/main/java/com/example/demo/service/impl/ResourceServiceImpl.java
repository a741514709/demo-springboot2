package com.example.demo.service.impl;

import com.example.demo.model.Resource;
import com.example.demo.respository.ResourceRepository;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource save(Resource resource){
        return resourceRepository.save(resource);
    }
}
