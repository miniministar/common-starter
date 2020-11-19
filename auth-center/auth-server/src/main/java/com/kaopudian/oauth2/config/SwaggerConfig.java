package com.exercise.oauth2.config;

import com.exercise.common.component.config.BaseSwaggerConfig;
import com.exercise.common.core.domain.SwaggerProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    @Value("${swagger.enable}")
    private Boolean enable;

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .enable(enable)
                .apiBasePackage("com.exercise.oauth2.controller" + SPLITOR + "com.exercise.system.controller")
                .title("认证服务器")
                .description("认证服务器后台相关接口文档")
                .contactName("auth-server")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
