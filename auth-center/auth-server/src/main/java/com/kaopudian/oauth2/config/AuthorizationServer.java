package com.exercise.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource)
    {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Bean
    public ClientDetailsService clientDetailsService(DataSource dataSource)
    {
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        clientDetailsService.setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }


    // 配置客户端详细信息
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    // 令牌管理服务
    public AuthorizationServerTokenServices tokenServices()
    {
        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(clientDetailsService);  // 客户端信息服务
        service.setSupportRefreshToken(true);   // 是否产生刷新令牌
        service.setTokenStore(tokenStore);  // 设置令牌存储策略
        // 令牌增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
        service.setTokenEnhancer(tokenEnhancerChain);
        service.setAccessTokenValiditySeconds(jwtConfig.getExpiration());// 令牌默认有效期 2 小时
        service.setRefreshTokenValiditySeconds(jwtConfig.getRefreshExpiration());
        return service;
    }

    /**
     * /oauth/authorize     授权端点
     * /oauth/token         令牌断点
     * /oauth/confirm-access用户确认授权提交端点
     * /auth/error          授权服务错误信息断电
     * /auth/check_token    用户资源服务访问的令牌解析断电
     * /oauth/token_key     提供公有密钥的端点，如果你使用jwt令牌的话
     */

    /**
     *  令怕i访问端点
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // 密码管理模式
                .authenticationManager(authenticationManager)
                // 授权码模式
                .authorizationCodeServices(authorizationCodeServices)
                .tokenServices(tokenServices()) // 令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST); // 允许post提交
    }


    /**
     *  令牌访问端点的安全策略
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")         // /oauth/token_key  公开
                .checkTokenAccess("permitAll()")       // /oauth/check_token  检测令牌
                .allowFormAuthenticationForClients();  // 允许通过表单认证，申请令牌

    }


}
