package com.exercise.security;

import com.exercise.security.common.Myproperties;
import com.exercise.security.filter.MyAuthFilter;
import com.exercise.security.filter.MyLoginFilter;
import com.exercise.security.login.MyAuthEntryPoint;
import com.exercise.security.url.UrlDecisionManager;
import com.exercise.security.url.UrlDeniedHandler;
import com.exercise.security.url.UrlMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Myproperties myProperties;

    /**
     * 访问鉴权 - 认证token、签名...
     */
    @Autowired
    private MyAuthFilter authFilter;
    /**
     * 访问权限认证异常处理
     */
    @Autowired
    private MyAuthEntryPoint entryPoint;
    /**
     * 用户密码校验过滤器
     */
    @Autowired
    private MyLoginFilter loginFilter;

    // 上面是登录认证相关  下面为url权限相关 - ========================================================================================

    /**
     * 获取访问url所需要的角色信息
     */
    @Autowired
    private UrlMetadataSource metadataSource;
    /**
     * 认证权限处理 - 将上面所获得角色权限与当前登录用户的角色做对比，如果包含其中一个角色即可正常访问
     */
    @Autowired
    private UrlDecisionManager decisionManager;
    /**
     * 自定义访问无权限接口时403响应内容
     */
    @Autowired
    private UrlDeniedHandler deniedHandler;

//    public SecurityConfig( MyAuthEntryPoint entryPoint, MyLoginFilter loginFilter, UrlMetadataSource metadataSource, UrlDecisionManager decisionManager, UrlDeniedHandler deniedHandler) {
////        this.authFilter = authFilter;
//        this.entryPoint = entryPoint;
//        this.loginFilter = loginFilter;
//        this.metadataSource = metadataSource;
//        this.decisionManager = decisionManager;
//        this.deniedHandler = deniedHandler;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.antMatcher("/**").authorizeRequests();
        // 允许匿名的url - 可理解为放行接口 - 除配置文件忽略url以外，其它所有请求都需经过认证和授权
        for (String url : myProperties.getAuth().getIgnoreUrls()) {
            registry.antMatchers(url).permitAll();
        }
        //让Spring security放行所有preflight request
        registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

        // 禁用CSRF 开启跨域
        http.csrf().disable().cors();
        // 未登录认证异常
        http.exceptionHandling().authenticationEntryPoint(entryPoint);

        // 登录过后访问无权限的接口时自定义403响应内容
        http.exceptionHandling().accessDeniedHandler(deniedHandler);

        // url权限认证处理
        registry.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(metadataSource);
                o.setAccessDecisionManager(decisionManager);
                return o;
            }
        });

        // 不创建会话 - 即通过前端传token到后台过滤器中验证是否存在访问权限
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 自动登录 - cookie储存方式
        registry.and().rememberMe();
        // 其余所有请求都需要认证
        registry.anyRequest().authenticated();
        // 防止iframe 造成跨域
        registry.and().headers().frameOptions().disable();

        // 自定义过滤器在登录时认证用户名、密码
        http.addFilterAt(loginFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authFilter, BasicAuthenticationFilter.class);
    }
}
