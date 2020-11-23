package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.model.SysMenu;
import com.exercise.security.model.SysRoleMenu;
import com.exercise.security.model.SysRoleMenuExample;

import java.util.List;

public interface RoleMenService {

    long countByExample(SysRoleMenuExample example);

    int deleteByPrimaryKey(Long id);

    int deleteByExample(SysRoleMenuExample example);

    int insert(SysRoleMenu record);

    List<SysRoleMenu> selectByExample(SysRoleMenuExample example);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    ResultDTO<SysRoleMenu> getPage(RequestDTO<SysRoleMenu> params);

    SysRoleMenuExample setCondition(SysRoleMenu filter);

    int deleteByRoleId(Long roleId);

    long countRoleMenu(Long roleId);

    void setRoleMenuCache(Long roleId, List<SysMenu> menus);
}
