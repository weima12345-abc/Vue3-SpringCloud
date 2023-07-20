package com.example.userimpl.controller;

import com.example.userapi.VO.OrderRecord;
import com.example.userapi.VO.ResultFul;
import com.example.userimpl.dao.impl.AccountDaoImpl;
import com.example.userimpl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
@PostMapping("/login")
    public ResultFul<String> login(String accountUsername,String accountPassword){
        try{
            var ID=userService.login(accountUsername,accountPassword);
            if(ID!=-1){
                return new ResultFul<>("200", String.valueOf(ID),"success");
            }else{
                throw new Exception("登录失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    return new ResultFul<>("406",null,"账号或密码错误");
    }
@PostMapping("/register")
    public ResultFul<String> register(String userName,String userPhone,String accountPassword,String accountUsername){
    try{
        var acc=userService.register(userName,accountPassword,accountUsername,userPhone);
        if(acc==true){
            return new ResultFul<>("200",null,"success");
        }else {
            throw new Exception("注册失败");
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return new ResultFul<>("406",null,"注册失败");
}
@PostMapping("/updatePassword")
public ResultFul<String>updatePassword(String accountUsername,String accountPassword){
    try{
        var acc=userService.updatePassword(accountUsername,accountPassword);
        if(acc==true){
            return new ResultFul<>("200",null,"success");
        }else {
            throw new Exception("修改密码失败");
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return new ResultFul<>("406",null,"修改密码失败");
    }
    @ResponseBody
    @PostMapping("/getList")
    public ResultFul<List<OrderRecord>>getList(int userid) {
        try {
            var acc=userService.getList(userid);
            if(acc!=null){
                return new ResultFul<>("200", acc,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultFul<>("406",null,"查询失败");
    }
    @PostMapping("insertRecord")
    public ResultFul<String>buyRecord(String commodityName,int commodityId,int userId){
    try{
        var acc=userService.buyRecord(commodityName,commodityId,userId);
        if (acc){
            return new ResultFul<>("200", null,"success");
        }
    }catch (Exception e){
        e.printStackTrace();
    }
        return new ResultFul<>("406",null,"插入购买记录失败");
    }


}

