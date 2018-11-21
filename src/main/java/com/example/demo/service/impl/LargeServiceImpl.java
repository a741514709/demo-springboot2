package com.example.demo.service.impl;

import com.example.demo.DTO.LargeDTO;
import com.example.demo.model.Large;
import com.example.demo.respository.LargeRepository;
import com.example.demo.service.LargeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LargeServiceImpl implements LargeService {

    @Autowired
    private LargeRepository largeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public LargeDTO findById(Integer id){
        Large large=largeRepository.findById(id).orElse(null);
        LargeDTO largeDTO=new LargeDTO();
        BeanUtils.copyProperties(large,largeDTO);
        return largeDTO;

    }
}
