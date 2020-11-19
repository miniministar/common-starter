package com.exercise.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.exercise.admin.mapper","com.exercise.admin.dao", "com.exercise.security.mapper"})
public class MyBatisConfig {
}
