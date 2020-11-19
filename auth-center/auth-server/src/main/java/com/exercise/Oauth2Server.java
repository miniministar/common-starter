package com.exercise;

import com.exercise.oauth2.config.IgnoreUrlsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(IgnoreUrlsConfig.class)
@SpringBootApplication
public class Oauth2Server {
    public static void main(String[] args) {
        SpringApplication.run(com.exercise.Oauth2Server.class, args);
    }
}
