package com.example.forwardimpl.controller;

import com.example.forwardimpl.service.SenServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SenController {
    @Autowired
    private SenServer senServer;
    @PostMapping("/hello")
    public String hello() {
        try {
            return senServer.hello();
        }catch (Exception e){
            return "熔断";
        }

    }
}
