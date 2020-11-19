package com.exercise.security.filter;

import com.alibaba.fastjson.JSONObject;
import com.exercise.security.common.MyConstrants;
import com.exercise.security.model.SysUser;
import com.exercise.security.login.MyAuthenticationFailureHandler;
import com.exercise.security.login.MyAuthenticationManager;
import com.exercise.security.login.MyAuthenticationSuccessHandler;
import com.exercise.security.util.MyMultiReadHttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p> 自定义用户密码校验过滤器 </p>
 */
@Slf4j
@Component
public class MyLoginFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * @param manager:       认证管理器
     * @param successHandler: 认证成功处理
     * @param failureHandler: 认证失败处理
     */
    public MyLoginFilter(MyAuthenticationManager manager, MyAuthenticationSuccessHandler successHandler, MyAuthenticationFailureHandler failureHandler) {
        super(new AntPathRequestMatcher("/login", "POST"));
        this.setAuthenticationManager(manager);
        this.setAuthenticationSuccessHandler(successHandler);
        this.setAuthenticationFailureHandler(failureHandler);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if (request.getContentType() == null || !request.getContentType().contains(MyConstrants.REQUEST_HEADERS_CONTENT_TYPE)) {
            throw new AuthenticationServiceException("支持的请求头类型为: " + MyConstrants.REQUEST_HEADERS_CONTENT_TYPE);
        }

        UsernamePasswordAuthenticationToken authRequest;
        try {
            MyMultiReadHttpServletRequest wrappedRequest = new MyMultiReadHttpServletRequest(request);
            // 将前端传递的数据转换成jsonBean数据格式
            SysUser user = JSONObject.parseObject(wrappedRequest.getBodyJsonStrByJson(wrappedRequest), SysUser.class);
            authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), null);
            authRequest.setDetails(authenticationDetailsSource.buildDetails(wrappedRequest));
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
