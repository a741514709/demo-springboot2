package com.example.demo.controller;

import com.example.demo.DTO.LargeDTO;
import com.example.demo.service.LargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YF-20170911 on 2018/11/20.
 */
@RestController
@RequestMapping("large")
public class LargeController {

    @Autowired
    private LargeService largeService;

    @GetMapping(value = "/index")
    public LargeDTO index(){
        return largeService.findById(1);
    }
}
