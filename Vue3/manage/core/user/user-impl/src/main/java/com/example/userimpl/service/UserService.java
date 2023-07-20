package com.example.userimpl.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.userapi.VO.OrderRecord;
import com.example.userimpl.Ref;
import com.example.userimpl.dao.impl.AccountDaoImpl;
import com.example.userimpl.dao.impl.LoggDaoImpl;
import com.example.userimpl.dao.impl.OrderRecordDaoImpl;
import com.example.userimpl.dao.impl.UserMessageDaoImpl;
import com.example.userimpl.dao.intf.AccountDao;
import com.example.userimpl.entity.AccountEntity;
import com.example.userimpl.entity.LoggEntity;
import com.example.userimpl.entity.OrderRecordEntity;
import com.example.userimpl.entity.UserMessageEntity;
import com.example.userimpl.wrapper.AccountQuery;
import com.example.userimpl.wrapper.OrderRecordQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private AccountDaoImpl accountDao;
    private UserMessageDaoImpl userMessageDao;
    private LoggDaoImpl loggDao;
    public int login(String accountUsername,String accountPassword){
        try{
            var acc=accountDao.mapper().findOne(new AccountQuery().where.accountUsername().eq(accountUsername).and.accountPassword().eq(accountPassword).end());
            if(acc==null){
                loggDao.mapper().insert(new LoggEntity(null,accountUsername,new Date().toString()));
                return -1;
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        var ans=accountDao.mapper().findOne(new AccountQuery().where.accountUsername().eq(accountUsername).end()).getUserId();
        return  ans;
    }

    public boolean register(String userName,String userPhone,String accountPassword,String accountUsername){
        try{
            var acc=new AccountEntity(null,accountUsername,accountPassword);
            accountDao.mapper().insert(acc);
            var userId=acc.getUserId();
            var asn=new UserMessageEntity(accountUsername,userId,userName,userPhone);
            userMessageDao.mapper().insert(asn);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        }

        public boolean updatePassword(String accountUsername,String accountPassword){
        try{
            accountDao.updateById(accountDao.mapper().findOne(new AccountQuery().where.accountUsername().eq(accountUsername).end()).setAccountPassword(accountPassword));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
        }
        @Autowired
        private OrderRecordDaoImpl orderRecordDao;
        public List<OrderRecord> getList(int id){
            try {
                ArrayList<OrderRecord> arrayList = new ArrayList<>();
                var ans = orderRecordDao.mapper().stdPagedEntity(new OrderRecordQuery().where.userId().eq(id).end().limit(10)).getData();
                for (OrderRecordEntity an : ans) {
                    if (an==null||an.getUserId()==null){
                        continue;
                    }
                    OrderRecord orderRecord = new OrderRecord();
                    orderRecord.setUserId(an.getUserId());
                    orderRecord.setCommodityId(an.getCommodityId());
                    orderRecord.setBuyTime(an.getBuyTime());
                    orderRecord.setCommodityName(an.getCommodityName());
                    orderRecord.setRecordId(an.getRecordId());
                    arrayList.add(orderRecord);
                }

                return arrayList;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }

        }
    public boolean buyRecord(String commodityName,int commodityId,int userId){
            try{
                var time=new Date();
                var acc=new OrderRecordEntity(null,time,commodityId,commodityName,userId);
                orderRecordDao.mapper().insert(acc);
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        return false;
    }
    @Autowired
    public void setLoggDao(LoggDaoImpl loggDao){this.loggDao=loggDao;}
    @Autowired
    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }
    @Autowired
    public void setUserMessageDao(UserMessageDaoImpl userMessageDao){this.userMessageDao=userMessageDao;}
    }


