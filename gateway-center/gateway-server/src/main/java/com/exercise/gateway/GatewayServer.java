package com.exercise.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class GatewayServer {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServer.class, args);
    }
}
