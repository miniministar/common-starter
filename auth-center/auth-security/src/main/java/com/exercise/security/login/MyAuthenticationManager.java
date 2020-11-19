package com.exercise.security.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 自定义认证管理器
 */
@Component
@Slf4j
public class MyAuthenticationManager implements AuthenticationManager {
    private final MyAuthenticationProvider authenticationProvider;

    public MyAuthenticationManager(MyAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("自定义认证管理器");
        Authentication result = authenticationProvider.authenticate(authentication);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new ProviderNotFoundException("Authentication failed!");
    }

}
