package com.example.nacos.controller;

import com.example.nacos.service.FeignUser;
import com.example.userapi.VO.OrderRecord;
import com.example.userapi.VO.ResultFul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private FeignUser feignUser;

    @PostMapping("/login")
    public ResultFul<String> login(String accountUsername,String accountPassword){
        return feignUser.login(accountUsername,accountPassword);
    }

    @PostMapping("/register")
    public ResultFul<String> register(String userName,String userPhone,String accountPassword,String accountUsername){
        return feignUser.register(userName,userPhone,accountPassword,accountUsername);
    }
    @PostMapping("/updatePassword")
    public ResultFul<String>updatePassword(String accountUsername,String accountPassword){
        return feignUser.updatePassword(accountUsername,accountPassword);
    }
    @ResponseBody
    @PostMapping("/getList")
    public ResultFul<List<OrderRecord>>getList(int userid) {
        return feignUser.getList(userid);
    }
    @PostMapping("insertRecord")
    public ResultFul<String>buyRecord(String commodityName,int commodityId,int userId){
        return feignUser.buyRecord(commodityName,commodityId,userId);
    }
}
