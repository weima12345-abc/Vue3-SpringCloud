package com.example.nacos.service;

import com.example.userapi.VO.OrderRecord;
import com.example.userapi.VO.ResultFul;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(path = "/user",name = "user-impl")
public interface FeignUser {

    @PostMapping("/login")
    ResultFul<String> login(@RequestParam String accountUsername, @RequestParam String accountPassword);
    @PostMapping("/register")
    ResultFul<String> register(@RequestParam String userName,@RequestParam String userPhone,@RequestParam String accountPassword,@RequestParam String accountUsername);
    @PostMapping("/updatePassword")
    public ResultFul<String>updatePassword(@RequestParam String accountUsername,@RequestParam String accountPassword);
    @PostMapping("/getList")
    public ResultFul<List<OrderRecord>>getList(@RequestParam int userid);
    @PostMapping("insertRecord")
    public ResultFul<String>buyRecord(@RequestParam String commodityName,@RequestParam int commodityId,@RequestParam int userId);



}
