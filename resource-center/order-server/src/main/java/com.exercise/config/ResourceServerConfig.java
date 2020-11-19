package com.exercise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${project.resourceId}")
    public String resourceId;
    @Value("${project.scope}")
    public String scope;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('"+scope+"')")
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        super.configure(http);
    }
    // 资源服务令牌解析服务
    /**
     * 使用远程服务请求授权服务器校验的token，必须制定校验token 的url， client_id,client_secret
     * @return
     */
//    @Bean
//    public ResourceServerTokenServices tokenServices()
//    {
//        RemoteTokenServices service = new RemoteTokenServices();
//        service.setCheckTokenEndpointUrl("http://localhost:8202/oauth/check_token");
//        service.setClientId("c1");
//        service.setClientSecret("secret");
//        return service;
//    }

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceId) // 资源id
//                .tokenServices(tokenServices()) // 验证令牌的服务
                .tokenStore(tokenStore) // 验证令牌的服务
                .stateless(true);
    }
}
