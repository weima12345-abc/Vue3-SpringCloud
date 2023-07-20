package com.example.nacos.controller;

import com.example.commodityapi.VO.Commodity;
import com.example.commodityapi.VO.ResultFul;
import com.example.commodityapi.VO.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private com.example.nacos.service.FeignCommodity feignCommodity;
    @PostMapping("/getShoppingList")
    public ResultFul<List<ShoppingCart>> getList(int userid){
        return feignCommodity.getList(userid);
    }

    @PostMapping("/insertShoppingCart")
    public com.example.userapi.VO.ResultFul<String> buyRecord(String commodityName, int commodityId, int userId, float commodityPrice){
        return feignCommodity.buyRecord(commodityName,commodityId,userId,commodityPrice);
    }
    @PostMapping("/getList")
    public com.example.userapi.VO.ResultFul<List<Commodity>> getList(){
        return feignCommodity.getList();
    }
}
