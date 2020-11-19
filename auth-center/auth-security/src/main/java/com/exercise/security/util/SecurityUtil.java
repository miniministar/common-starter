package com.exercise.security.util;

import com.exercise.security.model.SysUser;
import com.exercise.security.dto.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static SysUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUser securityUser = ((SecurityUser) authentication.getPrincipal());
        if(securityUser!=null) return securityUser.getCurrentUserInfo();
        return null;
    }
}
