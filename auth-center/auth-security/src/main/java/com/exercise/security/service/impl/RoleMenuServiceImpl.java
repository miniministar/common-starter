package com.exercise.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.exercise.common.component.cache.CacheService;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.constant.Constants;
import com.exercise.security.mapper.SysRoleMenuMapper;
import com.exercise.security.model.SysMenu;
import com.exercise.security.model.SysRoleMenu;
import com.exercise.security.model.SysRoleMenuExample;
import com.exercise.security.service.RoleMenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleMenuServiceImpl implements RoleMenService {

    @Autowired
    private SysRoleMenuMapper mapper;
    @Autowired
    private CacheService cacheService;

    @Override
    public long countByExample(SysRoleMenuExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(SysRoleMenuExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int insert(SysRoleMenu record) {
        return mapper.insert(record);
    }

    @Override
    public List<SysRoleMenu> selectByExample(SysRoleMenuExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysRoleMenu selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleMenu record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysRoleMenu> getPage(RequestDTO<SysRoleMenu> params) {
        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        SysRoleMenu filter = params.getFilter();
        SysRoleMenuExample example = setCondition(filter);
        List<SysRoleMenu> list = selectByExample(example);
        ResultDTO<SysRoleMenu> page = ResultDTO.restPage(list);
        return page;
    }

    @Override
    public SysRoleMenuExample setCondition(SysRoleMenu filter) {
        SysRoleMenuExample example = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( filter.getRoleId() != null ) {
                criteria.andRoleIdEqualTo(filter.getRoleId());
            }
        }
        return example;
    }

    @Override
    public int deleteByRoleId(Long roleId) {
        SysRoleMenuExample example = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return mapper.deleteByExample(example);
    }

     public void setRoleMenuCache(Long roleId, List<SysMenu> menus) {
        Set<Long> menuIds = null;
        if(cacheService.hasKey(Constants.ROLE_ID_MENUS + roleId)) {
            menuIds = cacheService.getCacheObject(Constants.ROLE_ID_MENUS + roleId);
        }else {
            List<Long> list = selectRoleMenuIds(roleId);
            if(list != null)
            menuIds = new HashSet<>( list );
        }

        if(!CollectionUtils.isEmpty(menuIds)) {
            for (Long menuId: menuIds ) {
                Set<Long> roleIds = cacheService.getCacheObject(Constants.MENU_ID_ROLES + menuId);
                if(!CollectionUtils.isEmpty(roleIds)) {
                    roleIds.remove(roleId);
                    cacheService.setCacheObject(Constants.MENU_ID_ROLES + menuId, roleIds);
                }
            }
        }

        //设置
        Set<Long> newMenuIds = new HashSet<>();
        if(!CollectionUtils.isEmpty(menus)) newMenuIds = menus.stream().map(SysMenu::getId).collect(Collectors.toSet());
        cacheService.setCacheObject(Constants.ROLE_ID_MENUS + roleId, newMenuIds);
        for (Long menuId: newMenuIds ) {
            Set<Long> roleIds = null;
            if(!cacheService.hasKey(Constants.MENU_ID_ROLES + menuId)) {
                roleIds = new HashSet<>();
            }else {
                roleIds = cacheService.getCacheObject(Constants.MENU_ID_ROLES + menuId);
            }
            roleIds.add(roleId);
            cacheService.setCacheObject(Constants.MENU_ID_ROLES + menuId, roleIds);
        }
    }

    public List<Long> selectRoleMenuIds(Long roleId) {
        SysRoleMenuExample example = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<SysRoleMenu> sysRoleMenus = mapper.selectByExample(example);
        if(sysRoleMenus == null) return  null;
        return sysRoleMenus.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
    }

    @Override
    public long countRoleMenu(Long roleId) {
        SysRoleMenuExample example = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return countByExample(example);
    }
}
