package com.exercise.oauth2.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class JwtConfig {
    //jwt令牌
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
//    @Value("${jwt.secretKey}")
//    private String secretKey;
    @Value("${jwt.expiration}")
    private Integer expiration;
    @Value("${jwt.refresh.expiration}")
    private Integer refreshExpiration;
}
