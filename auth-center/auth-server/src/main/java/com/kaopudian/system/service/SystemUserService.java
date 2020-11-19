package com.exercise.system.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.oauth2.model.SysUser;
import com.exercise.oauth2.model.SysUserExample;

import java.util.List;

public interface SystemUserService {

    long countByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    ResultDTO<SysUser> getPage(RequestDTO<SysUser> params);

    SysUserExample setCondition(SysUser filter);
}
