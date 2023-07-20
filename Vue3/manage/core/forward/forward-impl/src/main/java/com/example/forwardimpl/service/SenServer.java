package com.example.forwardimpl.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class SenServer {


    @SentinelResource(value = "ott")
    public String hello() {
        return "Hello you can get";
    }


}
