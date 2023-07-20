package com.example.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "forward-impl",path = "/test")
public interface FeignForward {
    @PostMapping("/hello")
    public String hello();
}
