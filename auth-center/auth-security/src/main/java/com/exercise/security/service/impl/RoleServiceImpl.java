package com.exercise.security.service.impl;

import com.exercise.common.component.cache.CacheService;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.constant.Constants;
import com.exercise.common.core.exception.ApiException;
import com.exercise.security.mapper.SysRoleMapper;
import com.exercise.security.model.*;
import com.exercise.security.service.MenuService;
import com.exercise.security.service.RoleMenService;
import com.exercise.security.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper mapper;
    @Autowired
    private RoleMenService roleMenService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private CacheService cacheService;

    @Override
    public long countByExample(SysRoleExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysRole record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysRole> selectByExample(SysRoleExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysRole selectByPrimaryKey(Long id) {
        SysRole role = mapper.selectByPrimaryKey(id);
        role = filterRow(role);
        return role;
    }

    public SysRole filterRow(SysRole role) {
        role.setMenus(getRoleAllMenus(role.getId()));
        return role;
    }

    public List<SysMenu> getRolesAllMenus(List<Long> roleIds) {
        if(CollectionUtils.isEmpty(roleIds)) return  new ArrayList<>();
        SysRoleMenuExample roleMenuExample = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = roleMenuExample.createCriteria();
        if(roleIds.size() > 0) {
            criteria.andRoleIdIn(roleIds);
        }else {
            criteria.andRoleIdEqualTo(roleIds.get(0));
        }
        List<SysRoleMenu> sysRoleMenus = roleMenService.selectByExample(roleMenuExample);
        if(CollectionUtils.isEmpty(sysRoleMenus)) return new ArrayList<>();
        List<Long> collect = sysRoleMenus.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        SysMenuExample sysMenuExample = new SysMenuExample();
        SysMenuExample.Criteria criteria1 = sysMenuExample.createCriteria();
        if(collect.size() > 1) {
            criteria1.andIdIn(collect);
        }else {
            criteria1.andIdEqualTo(collect.get(0));
        }
        List<SysMenu> sysMenus = menuService.selectByExample(sysMenuExample);
        return menuService.constructTree(sysMenus);
    }

    public List<SysMenu> getRoleAllMenus(Long roleId) {
        SysRoleMenuExample roleMenuExample = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = roleMenuExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<SysRoleMenu> sysRoleMenus = roleMenService.selectByExample(roleMenuExample);
        if(CollectionUtils.isEmpty(sysRoleMenus)) return new ArrayList<>();
        List<Long> collect = sysRoleMenus.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        SysMenuExample sysMenuExample = new SysMenuExample();
        SysMenuExample.Criteria criteria1 = sysMenuExample.createCriteria();
        if(collect.size() > 1) {
            criteria1.andIdIn(collect);
        }else {
            criteria1.andIdEqualTo(collect.get(0));
        }
        return menuService.selectByExample(sysMenuExample);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        int i = mapper.updateByPrimaryKeySelective(record);
        SysRole role = mapper.selectByPrimaryKey(record.getId());
        setRoleCache(role);
        return i;
    }

    @Override
    public ResultDTO<SysRole> getPage(RequestDTO<SysRole> params) {
        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        SysRole filter = params.getFilter();
        SysRoleExample example = setCondition(filter);
        List<SysRole> list = selectByExample(example);
        ResultDTO<SysRole> page = ResultDTO.restPage(list);
        return page;
    }

    @Override
    public SysRoleExample setCondition(SysRole filter) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( !StringUtils.isEmpty(filter.getName()) ) {
                criteria.andNameLike(filter.getName());
            }
            if( !StringUtils.isEmpty(filter.getCode()) ) {
                criteria.andCodeLike(filter.getCode());
            }
        }
        return example;
    }


    @Override
    public int setMenu(SysRole entity) {
        if(entity == null) throw new ApiException("参数为空");
        if(entity.getId() == null) throw new ApiException("角色id不能为空");

        roleMenService.setRoleMenuCache(entity.getId(), entity.getMenus());

        int i = roleMenService.deleteByRoleId(entity.getId());

        List<SysMenu> menus = entity.getMenus();
        for (SysMenu menu: menus) {
            if(menu.getId() == null ) throw new ApiException("权限id不能为空");
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(entity.getId());
            sysRoleMenu.setMenuId(menu.getId());
            roleMenService.insert(sysRoleMenu);
        }
        return i;
    }

    @Override
    public List<SysRole> selectRoleByMenuIdFormCache(Long menuId) {
        boolean hasKey = cacheService.hasKey(Constants.MENU_ID_ROLES + menuId);
        List<SysRole> list = new ArrayList<>();
        if(hasKey) {
            Set<Long> roleIds = cacheService.getCacheObject(Constants.MENU_ID_ROLES + menuId);
            for (Long roleId: roleIds ) {
                SysRole role = null;
                if(cacheService.hasKey(Constants.ROLE_ID + roleId)){
                    role = cacheService.getCacheObject(Constants.ROLE_ID + roleId);
                }else {
                    role = mapper.selectByPrimaryKey(roleId);
                    setRoleCache(role);
                }
                if(role != null)
                    list.add(role);
            }
        }else {
            Set<Long> roIds = new HashSet<>();
            list = selectRolesByMenuId(menuId);
            if(!CollectionUtils.isEmpty(list)) {
                for (SysRole role: list) {
                    roIds.add(role.getId());
                    setRoleCache(role);
                }
            }
            cacheService.setCacheObject(Constants.MENU_ID_ROLES + menuId, roIds);
        }
        return list;
    }

    public List<SysRole> selectRolesByMenuId(Long menuId) {
        SysRoleMenuExample example = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andMenuIdEqualTo(menuId);
        List<SysRoleMenu> sysRoleMenus = roleMenService.selectByExample(example);
        if(CollectionUtils.isEmpty(sysRoleMenus)) return null;

        SysRoleExample example1 = new SysRoleExample();
        SysRoleExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andIdIn(sysRoleMenus.stream().map(SysRoleMenu::getRoleId).collect(Collectors.toList()));
        return mapper.selectByExample(example1);
    }

    public void setRoleCache(SysRole role) {
        if(role!=null) {
            cacheService.setCacheObject(Constants.ROLE_ID + role.getId(), role);
        }
    }


}
