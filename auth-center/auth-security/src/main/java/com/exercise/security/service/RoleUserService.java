package com.exercise.security.service;

import com.exercise.security.model.SysRole;
import com.exercise.security.model.SysRoleUser;
import com.exercise.security.model.SysRoleUserExample;
import com.exercise.security.model.SysUser;

import java.util.List;

public interface RoleUserService {

    int insert(SysRoleUser record);

    int deleteByExample(SysRoleUserExample example);

    void setUserRole(SysUser user, List<SysRole> roles);

    int deleteUserAllRole(SysUser user);

    List<SysRole> getUserAllRole(Long userId);

    List<SysRoleUser> selectByExample(SysRoleUserExample example);

    long countByExample(SysRoleUserExample example);

    long countRoleUser(Long roleId);
}
