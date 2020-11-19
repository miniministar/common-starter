package com.exercise.security.dto;

import com.exercise.security.model.SysRole;
import com.exercise.security.model.SysUser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 * <p> 安全认证用户详情 </p>
 */
@Data
@Slf4j
public class SecurityUser implements UserDetails {
    /**
     * 当前登录用户
     */
    private transient SysUser currentUserInfo;
    /**
     * 角色
     */
    private transient List<SysRole> roleList;
    /**
     * 当前用户所拥有角色代码
     */
    private transient String roleCodes;

    private String token;

    public SecurityUser() {
    }

    public SecurityUser(SysUser user) {
        if (user != null) {
            this.currentUserInfo = user;
        }
    }

    public SecurityUser(SysUser user, List<SysRole> roleList) {
        if (user != null) {
            this.currentUserInfo = user;
            this.roleList = roleList;
            this.roleCodes = genRoleCodes(roleList);
        }
    }

    public static String genRoleCodes(List<SysRole> roleList) {
        String str = "";
        if (!CollectionUtils.isEmpty(roleList)) {
            StringJoiner roleCodes = new StringJoiner(",", "[", "]");
            roleList.forEach(e -> {
                if(e!= null)
                    roleCodes.add(e.getCode());
            });
            str = roleCodes.toString();
        }
        return  str;
    }

    /**
     * 获取当前用户所具有的角色
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (!CollectionUtils.isEmpty(this.roleList)) {
            for (SysRole role : this.roleList) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getCode());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return currentUserInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return currentUserInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}