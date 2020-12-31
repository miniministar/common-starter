package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.dto.UserPasswordPara;
import com.exercise.security.model.SysUser;
import com.exercise.security.model.SysUserExample;
import com.exercise.security.model.SysUserType;

import java.util.List;

public interface SystemUserService {

    long countByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByExample(SysUser record, SysUserExample example);

    ResultDTO<SysUser> getPage(RequestDTO<SysUser> params);

    SysUserExample setCondition(SysUser filter);

    String encode(String password);

    int updateUserType(SysUserType record);

    SysUser filterRow(SysUser sysUser);

    List<SysUser> filterRows(List<SysUser> list);

    SysUser getInitInfo();

    boolean changePassword(UserPasswordPara input);

    boolean verifyPassword(String plain, String cip);

    SysUser selectByUsername(String username);

    boolean resetPassword(String username);

    SysUser refreshToken();
}
