package com.example.nacos.service;

import com.example.commodityapi.VO.Commodity;
import com.example.commodityapi.VO.ResultFul;
import com.example.commodityapi.VO.ShoppingCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(path = "/commodity",name = "commodity-impl")
public interface FeignCommodity {
    @PostMapping("/getShoppingList")
    public ResultFul<List<ShoppingCart>> getList(@RequestParam int userid);

    @PostMapping("/insertShoppingCart")
    public com.example.userapi.VO.ResultFul<String> buyRecord(@RequestParam String commodityName,@RequestParam int commodityId,@RequestParam int userId,@RequestParam float commodityPrice);
    @PostMapping("/getList")
    public com.example.userapi.VO.ResultFul<List<Commodity>> getList();

}
