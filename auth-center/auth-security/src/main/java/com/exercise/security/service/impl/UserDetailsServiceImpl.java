package com.exercise.security.service.impl;

import com.exercise.common.component.cache.CacheService;
import com.exercise.common.core.constant.Constants;
import com.exercise.security.common.MyConstrants;
import com.exercise.security.common.Myproperties;
import com.exercise.security.dao.UserDao;
import com.exercise.security.dto.SecurityUser;
import com.exercise.security.mapper.SysUserMapper;
import com.exercise.security.model.SysRole;
import com.exercise.security.model.SysUser;
import com.exercise.security.model.SysUserExample;
import com.exercise.security.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 自定义userDetailsService - 认证用户详情
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserService {

    @Autowired
    private SysUserMapper mapper;
    @Autowired
    private UserDao userDao;
    @Autowired
    private Myproperties myproperties;
    @Autowired
    private CacheService cacheService;

    /***
     * 根据账号获取用户信息
     * @param username:
     * @return: org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("根据账号获取用户信息");
        // 从数据库中取出用户信息
        SysUser user = selectByUsername(username);
        // 判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        // 返回UserDetails实现类
        return constructLoginSecurityUser(user);
    }

    public SecurityUser getUserByUsername(String username) {
        SysUser user = selectByUsername(username);
        return constructLoginSecurityUser(user);
    }

    private SecurityUser constructLoginSecurityUser(SysUser user) {
        if(user == null) return null;
        List<SysRole> roles =  getUserRoles(user.getId());
        SysRole loginRole = new SysRole();
        loginRole.setCode(MyConstrants.ROLE_LOGIN);
        roles.add(loginRole);
        return new SecurityUser(user, roles);
    }


    /**
     * 根据用户id获取角色权限信息
     *
     * @param userId
     * @return
     */
    public List<SysRole> getUserRoles(Long userId) {
        return userDao.findRoleByUserId(userId);
    }


    /**
     * 生成jwt访问令牌
     * @param roleCodes
     * @param username
     * @return
     */
    public String geneJwt(String roleCodes, String username) {
        // 生成jwt访问令牌
        String jwt = Jwts.builder()
                // 用户角色
                .claim(MyConstrants.ROLE_LOGIN, roleCodes)
                // 主题 - 存用户名
                .setSubject(username)
                // 过期时间 - 30分钟
//                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 1000 * myproperties.getAuth().getTokenExpireTime()))
                // 加密算法和密钥
                .signWith(SignatureAlgorithm.HS512, MyConstrants.SALT)
                .compact();
        return jwt;
    }

    public SysUser getAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null) {
            SecurityUser securityUser = ((SecurityUser) auth.getPrincipal());
            if(securityUser!=null)
            return securityUser.getCurrentUserInfo();
        }
        return null;
    }

    @Override
    public SysUser selectByUsername(String username) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> userList = mapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList))
            return null;
        return userList.get(0);
    }


    @Override
    public SecurityUser getUserForCache(String username) {
        Long userId =  cacheService.getCacheObject(Constants.USER_USERNAME_KEY + username);
        SecurityUser user = null;
        if(userId != null) {
            user =  cacheService.getCacheObject(Constants.USER_ID_KEY + userId);
        }
        if(user == null){
            user = getUserByUsername(username);
            setLoginSuccessCache(user);
        }
        return user;
    }

    @Override
    public boolean setLoginSuccessCache(SecurityUser user) {
        if(user == null) return false;
        int expireTime = myproperties.getAuth().getTokenExpireTime() + 1;
        Long userId = user.getCurrentUserInfo().getId();
        cacheService.setCacheObject(Constants.USER_USERNAME_KEY + user.getUsername(), userId , expireTime, TimeUnit.MINUTES);
        cacheService.setCacheObject(Constants.USER_ID_KEY + userId, user, expireTime, TimeUnit.MINUTES);
        return true;
    }
}
