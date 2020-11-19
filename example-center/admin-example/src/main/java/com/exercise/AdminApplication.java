package com.exercise;

import com.exercise.security.common.Myproperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 应用启动入口
 */
@EnableConfigurationProperties({Myproperties.class})
@SpringBootApplication
@EnableAsync //开启异步调用
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
