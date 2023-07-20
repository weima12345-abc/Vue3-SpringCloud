package com.example.forwardimpl.config;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableAspectJAutoProxy
@EnableTransactionManagement
public class MybatisConfig {
    @Bean
    public MapperFactory mapperFactory() {
        return new MapperFactory();
    }
}