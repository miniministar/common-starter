package com.exercise.security.login;

import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.constant.Constants;
import com.exercise.security.common.MyConstrants;
import com.exercise.security.dto.SecurityUser;
import com.exercise.security.manager.AsyncFactory;
import com.exercise.security.manager.AsyncManager;
import com.exercise.security.model.SysUser;
import com.exercise.security.service.UserService;
import com.exercise.security.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  <p> 认证成功处理 </p>
 */
@Component
@Slf4j
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        log.debug("认证成功处理");
        //认证成功后返回用户相关信息，菜单和用户信息

        SecurityUser securityUser = ((SecurityUser) auth.getPrincipal());
        userService.setLoginSuccessCache(securityUser);

        SysUser currentUserInfo = securityUser.getCurrentUserInfo();
        currentUserInfo.setPassword("");
        currentUserInfo.setToken(MyConstrants.TOKEN_TYPE + " " + userService.geneJwt(securityUser.getRoleCodes(), currentUserInfo.getUsername()));

        //======================system init start ========================================================
        //用户登陆成功后返回系统和用户的相关信息
        //======================system init end ========================================================

        //登陆日志
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(currentUserInfo.getUsername(), Constants.LOGIN_SUCCESS, "登录成功", currentUserInfo.getFullname()));

        ResponseUtils.out(response, CommonResult.success( currentUserInfo ) );
    }

}