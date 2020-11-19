package com.exercise.oauth2.component;


import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> 认证权限入口 - 未登录的情况下访问所有接口都会拦截到此 </p>
 */
@Slf4j
@Component
public class MyAuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        log.info("认证权限入口 - 未登录的情况下访问所有接口都会拦截到此");
        // 未登录 或 token过期
        if (e!=null){
            ResponseUtils.out(response, CommonResult.failed(e.getMessage()));
        } else {
            ResponseUtils.out(response, CommonResult.failed("Token过期!"));
        }
    }

}
