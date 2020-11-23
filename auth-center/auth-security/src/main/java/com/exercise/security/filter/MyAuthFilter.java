package com.exercise.security.filter;

import com.exercise.security.common.MyConstrants;
import com.exercise.security.dto.SecurityUser;
import com.exercise.security.login.MyAuthEntryPoint;
import com.exercise.security.service.impl.UserDetailsServiceImpl;
import com.exercise.security.util.MyMultiReadHttpServletRequest;
import com.exercise.security.util.MyMultiReadHttpServletResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

/**
 * <p> 访问鉴权 - 每次访问接口都会经过此 </p>
 */
@Slf4j
@Component
public class MyAuthFilter extends OncePerRequestFilter {

    @Autowired
    MyAuthEntryPoint entryPoint;

    private final UserDetailsServiceImpl userDetailsService;

    protected MyAuthFilter(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, AuthenticationException {

        MyMultiReadHttpServletRequest wrappedRequest = new MyMultiReadHttpServletRequest(request);
        MyMultiReadHttpServletResponse wrappedResponse = new MyMultiReadHttpServletResponse(response);
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            // 记录请求的消息体
            if (request.getContentType() != null && request.getContentType().contains("application/json") ) {
                logRequestBody(wrappedRequest);
            }

            // 前后端分离情况下，前端登录后将token储存在cookie中，每次访问接口时通过token去拿用户权限
            String jwtToken = wrappedRequest.getHeader(MyConstrants.REQUEST_HEADER);
            if (StringUtils.isNotBlank(jwtToken)) {
                // JWT相关start ===========================================
                // 获取jwt中的信息
                Claims claims = Jwts.parser().setSigningKey(MyConstrants.SALT).parseClaimsJws(jwtToken.replace(MyConstrants.TOKEN_TYPE, "")).getBody();
                // 获取当前登录用户名
                log.debug("当前登录用户名: " + claims.getSubject());
                // JWT相关end ===========================================

                // 检查token
                SecurityUser securityUser = userDetailsService.getUserForCache(claims.getSubject());
                if (securityUser == null || securityUser.getCurrentUserInfo() == null) {
                    throw new UsernameNotFoundException("用户名不存在！");
                }
                Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) securityUser.getAuthorities();

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUser, null, authorities);
                // 全局注入角色权限信息和登录用户基本信息
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        }catch (BadCredentialsException e){

            SecurityContextHolder.clearContext();
            this.entryPoint.commence(wrappedRequest, response, e);

        }catch (ExpiredJwtException e) {
            // jwt令牌过期
            SecurityContextHolder.clearContext();
            this.entryPoint.commence(wrappedRequest, response, null);
        } catch (AuthenticationException e) {
            SecurityContextHolder.clearContext();
            this.entryPoint.commence(wrappedRequest, response, e);
        } finally {
            stopWatch.stop();
            long usedTimes = stopWatch.getTotalTimeMillis();
            // 记录响应的消息体
            logResponseBody(wrappedRequest, wrappedResponse, usedTimes);
        }

    }

    /**
     * 记录请求的消息体
     * @param request
     * @return
     */
    private String logRequestBody(MyMultiReadHttpServletRequest request) {
        MyMultiReadHttpServletRequest wrapper = request;
        if (wrapper != null) {
            try {
                String bodyJson = wrapper.getBodyJsonStrByJson(request);
                String url = wrapper.getRequestURI().replace("//", "/");
                log.debug("-------------------------------- 请求url: " + url + " --------------------------------");
                MyConstrants.URL_MAPPING_MAP.put(url, url);
                //if(bodyJson.length() < 1000)log.debug("`{}` 接收到的参数: {}", url, bodyJson);

                return bodyJson;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 记录响应的消息体
     * @param request
     * @param response
     * @param useTime
     */
    private void logResponseBody(MyMultiReadHttpServletRequest request, MyMultiReadHttpServletResponse response, long useTime) {
        MyMultiReadHttpServletResponse wrapper = response;
        if (wrapper != null) {
            byte[] buf = wrapper.getBody();
            if (buf.length > 0) {
                String payload;
                try {
                    payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                } catch (UnsupportedEncodingException ex) {
                    payload = "[unknown]";
                }
                String requestURI = MyConstrants.URL_MAPPING_MAP.get(request.getRequestURI());
//                if(requestURI != null && ((requestURI.endsWith(".png") || requestURI.endsWith(".woff2") || requestURI.endsWith(".html")) ) ) {
//                    log.debug("`{}`  耗时:{}ms  返回的参数: {}", requestURI, useTime, payload);
//                }
            }
        }
    }

}
