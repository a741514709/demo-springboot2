package com.example.demo.service;

import com.example.demo.DTO.LargeDTO;
import com.example.demo.model.Large;
import com.example.demo.respository.LargeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YF-20170911 on 2018/11/20.
 */
@Service
public class LargeService {

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
