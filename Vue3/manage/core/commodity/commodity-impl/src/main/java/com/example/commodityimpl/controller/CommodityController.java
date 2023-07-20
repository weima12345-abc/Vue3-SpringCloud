package com.example.commodityimpl.controller;

import com.example.commodityapi.VO.Commodity;
import com.example.commodityapi.VO.ShoppingCart;
import com.example.commodityimpl.service.CommodityService;
import com.example.userapi.VO.ResultFul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    @ResponseBody
    @PostMapping("/getList")
    public ResultFul<List<Commodity>> getList() {
        try {
            var acc=commodityService.getList();
            if(acc!=null){
                return new ResultFul<>("200", acc,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultFul<>("406",null,"获取商品信息失败失败");
    }

    @PostMapping("/insertShoppingCart")
    public ResultFul<String>buyRecord(String commodityName,int commodityId,int userId,float commodityPrice){
        try{
            var acc=commodityService.shoppingCart(commodityName,commodityId,userId,commodityPrice);
            if (acc){
                return new ResultFul<>("200", null,"success");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResultFul<>("406",null,"插入购买记录失败");
    }

    @PostMapping("/getShoppingList")
    public ResultFul<List<ShoppingCart>>getList(int userid) {
        try {
            var acc=commodityService.getList(userid);
            if(acc!=null){
                return new ResultFul<>("200", acc,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultFul<>("406",null,"查询失败");
    }
}
