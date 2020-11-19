package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.model.SysMenu;
import com.exercise.security.model.SysRole;
import com.exercise.security.model.SysRoleExample;

import java.util.List;

public interface RoleService {

    long countByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    ResultDTO<SysRole> getPage(RequestDTO<SysRole> params);

    SysRoleExample setCondition(SysRole filter);

    int setMenu(SysRole entity);

    SysRole filterRow(SysRole role);

    List<SysMenu> getRoleAllMenus(Long roleId);

    List<SysMenu> getRolesAllMenus(List<Long> roleIds);
}
