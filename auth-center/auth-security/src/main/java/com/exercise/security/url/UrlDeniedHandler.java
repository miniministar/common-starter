package com.exercise.security.url;

import com.exercise.security.util.ResponseUtils;
import com.exercise.common.core.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证url权限 - 登录后访问接口无权限 - 自定义403无权限响应内容
 *  登录过后的权限处理 【注：要和未登录时的权限处理区分开哦~】
 */
@Component
@Slf4j
public class UrlDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        log.debug("认证url权限 - 登录后访问接口无权限 - 自定义403无权限响应内容");
        ResponseUtils.out(response, CommonResult.failed(e.getMessage()));
    }
}