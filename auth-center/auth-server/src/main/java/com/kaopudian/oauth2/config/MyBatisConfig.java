package com.exercise.oauth2.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.exercise.oauth2.mapper", "com.exercise.oauth2.dao.UserDao"})
public class MyBatisConfig {
}
