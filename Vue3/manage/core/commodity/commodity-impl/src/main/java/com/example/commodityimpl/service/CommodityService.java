package com.example.commodityimpl.service;

import com.example.commodityapi.VO.Commodity;
import com.example.commodityapi.VO.ShoppingCart;
import com.example.commodityimpl.dao.impl.CommodityDaoImpl;

import com.example.commodityimpl.dao.impl.ShoppingCartDaoImpl;
import com.example.commodityimpl.entity.CommodityEntity;

import com.example.commodityimpl.entity.ShoppingCartEntity;
import com.example.commodityimpl.wrapper.CommodityQuery;
import com.example.commodityimpl.wrapper.ShoppingCartQuery;
import com.example.userapi.VO.OrderRecord;
import com.example.userimpl.dao.impl.OrderRecordDaoImpl;
import com.example.userimpl.entity.OrderRecordEntity;
import com.example.userimpl.wrapper.OrderRecordQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Service
public class CommodityService {
    @Autowired
    private CommodityDaoImpl commodityDao;
    @Autowired
    private ShoppingCartDaoImpl shoppingCartDao;

    public List<Commodity> getList(){
            try {
                ArrayList<Commodity> arrayList = new ArrayList<>();
                var ans = commodityDao.mapper().stdPagedEntity(new CommodityQuery().limit(10)).getData();
                for (CommodityEntity an : ans){
                    if (an==null||an.getCommodityId()==null){
                        continue;
                    }
                    Commodity commodity=new Commodity();
                    commodity.setCommodityId(an.getCommodityId());
                    commodity.setCommodityName(an.getCommodityName());
                    commodity.setCommodityPrice(an.getCommodityPrice());
                    arrayList.add(commodity);
                }
                return arrayList;
                }catch (Exception e){
                e.printStackTrace();
            }
        return null;
        }
    public boolean shoppingCart(String commodityName,int commodityId,int userId,float commodityPrice){
        try{
            var acc=new ShoppingCartEntity(null,commodityId,commodityName,commodityPrice,userId);
            shoppingCartDao.mapper().insert(acc);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public List<ShoppingCart> getList(int id){
        try {
            ArrayList<ShoppingCart> arrayList = new ArrayList<>();
            var ans = shoppingCartDao.mapper().stdPagedEntity(new ShoppingCartQuery().where.userId().eq(id).end().limit(10)).getData();
            for (ShoppingCartEntity an: ans) {
                if (an==null||an.getUserId()==null){
                    continue;
                }
                ShoppingCart shoppingCart=new ShoppingCart();
                shoppingCart.setCommodityId(an.getCommodityId());
                shoppingCart.setCommodityName(an.getCommodityName());
                shoppingCart.setCommodityPrice(an.getCommodityPrice());
                shoppingCart.setUserId(an.getUserId());
                arrayList.add(shoppingCart);
            }
            return arrayList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
