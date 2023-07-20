package com.example.userimpl;

import com.example.userimpl.dao.impl.AccountDaoImpl;
import com.example.userimpl.service.UserService;
import com.example.userimpl.wrapper.AccountQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userTest {
    @Autowired
    private AccountDaoImpl accountDao;
    @Autowired
    private UserService userService;
    @Test
    public void test(){

        System.out.println(userService.login("123","123"));

    }
}
