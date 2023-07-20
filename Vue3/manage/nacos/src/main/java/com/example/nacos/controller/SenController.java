package com.example.nacos.controller;

import com.example.nacos.service.FeignForward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SenController {
    @Autowired
    private FeignForward feignForward;
    @RequestMapping("/hello")
    public String hello() {
        return feignForward.hello();
    }
}
