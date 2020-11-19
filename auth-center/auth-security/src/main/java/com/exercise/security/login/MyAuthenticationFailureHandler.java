package com.exercise.security.login;

import com.exercise.security.util.ResponseUtils;
import com.exercise.common.core.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p> 认证失败处理 - 前后端分离情况下返回json数据格式 </p>
 */
@Slf4j
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        ServletContext servletContext = request.getServletContext();

        CommonResult result;
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            result = CommonResult.failed(e.getMessage());
        } else if (e instanceof LockedException) {
            result = CommonResult.failed("账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            result = CommonResult.failed("证书过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            result = CommonResult.failed("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            result = CommonResult.failed("账户被禁用，请联系管理员!");
        } else {
            result = CommonResult.failed("登录失败!");
        }
        log.error("登录失败: {}", e.getMessage());
        ResponseUtils.out(response, result);
    }

}