package com.exercise.security.service;

import com.exercise.security.dto.SecurityUser;
import com.exercise.security.model.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    SecurityUser getUserByUsername(String username);

    SysUser selectByUsername(String username);

    String geneJwt(String roleCodes, String username);

    SecurityUser getUserForCache(String username);

    boolean setLoginSuccessCache(SecurityUser securityUser);
}