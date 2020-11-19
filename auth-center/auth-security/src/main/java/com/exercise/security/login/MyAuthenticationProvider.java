package com.exercise.security.login;

import com.exercise.security.dto.SecurityUser;
import com.exercise.security.service.impl.UserDetailsServiceImpl;
import com.exercise.security.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("登录认证处理");
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SecurityUser userInfo = null;
        try {
            userInfo = (SecurityUser) userDetailsService.loadUserByUsername(userName);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            LoginUtil.failLog(userName, e.getMessage());

            throw new UsernameNotFoundException(e.getMessage());
        }
        boolean isValid = passwordEncoder.matches(password, userInfo.getPassword());
//        boolean isValid = PasswordUtils.isValidPassword(password, userInfo.getPassword(), MyConstrants.SALT);
        // 验证密码
        if (!isValid) {
            LoginUtil.failLog(userName, "密码错误！");
            throw new BadCredentialsException("密码错误！");
        }

        // 前后端分离情况下 处理逻辑...
//        String token = PasswordUtils.encodePassword(String.valueOf(System.currentTimeMillis()), userInfo.getCurrentUserInfo().getSalt());
        // 当前用户所拥有角色代码
//        String roleCodes = userInfo.getRoleCodes();
        // 生成jwt访问令牌
//        String jwt = userDetailsService.geneJwt(roleCodes, userName);

//        Long id = userInfo.getCurrentUserInfo().getId();
        // 更新登录令牌

        return new UsernamePasswordAuthenticationToken(userInfo, password, userInfo.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
