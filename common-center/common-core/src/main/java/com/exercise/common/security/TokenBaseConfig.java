package com.exercise.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

public class TokenBaseConfig {
    /**
     * 秘钥同认证服务器的相同
     */
    private static final String SIGNING_KEY = "auth-server@123456";

    @Bean
    public TokenStore tokenStore()
    {
        return new JwtTokenStore(assessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter assessTokenConverter()
    {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }
}
