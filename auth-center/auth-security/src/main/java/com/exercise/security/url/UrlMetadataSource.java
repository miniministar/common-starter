package com.exercise.security.url;

import cn.hutool.core.util.StrUtil;
import com.exercise.security.common.MyConstrants;
import com.exercise.security.common.Myproperties;
import com.exercise.security.dao.UserDao;
import com.exercise.security.model.SysMenu;
import com.exercise.security.model.SysRole;
import com.exercise.security.service.MenuService;
import com.exercise.security.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 获取访问该url所需要的用户角色权限信息
 * 执行完之后到 `UrlAccessDecisionManager` 中认证权限
 */
@Component
@Slf4j
public class UrlMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private Myproperties myProperties;
    @Autowired
    private UserDao userDao;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    PathMatcher pathMatcher =  new AntPathMatcher();

    /***
     * 返回该url所需要的用户权限信息
     *
     * @param object: 储存请求url信息
     * @return: null：标识不需要任何权限都可以访问
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取当前请求url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        // 获取当前请求url
        if(requestUrl != null && requestUrl.contains("?")){
            requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
        }

        List<String> ignoreUrls = myProperties.getAuth().getIgnoreUrls();
        for (String ignoreUrl : ignoreUrls) {
            if ( StrUtil.isNotBlank(requestUrl) && pathMatcher.match(ignoreUrl, requestUrl) ) {
                return null;
            }
        }

        // 数据库中url对应菜单  todo 一个接口地址对应一个菜单，一个接口不可对应多个菜单
        SysMenu permission = menuService.selectMenuByCache(requestUrl);
        //userDao.selectMenu(requestUrl);
        // 获取该url所对应的权限
        if (permission != null ) {
            // 对应角色权限
            List<SysRole> permissions = roleService.selectRoleByMenuIdFormCache(permission.getId());

//            List<SysRole> permissions = userDao.selectRoleByMenuId(permission.getId());
            List<String> roles = new LinkedList<>();
            if (!CollectionUtils.isEmpty(permissions)){
                permissions.forEach( e -> {
                    roles.add(e.getCode());
                });
            }
            String[] strings = roles.toArray(new String[roles.size()]);
            // 保存该url对应角色权限信息
            return SecurityConfig.createList(strings);
        }

        // 如果数据中没有找到相应url资源，只需要要求用户登录再进行操作
        return SecurityConfig.createList(MyConstrants.ROLE_LOGIN);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
