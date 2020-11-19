package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.model.SysUserType;
import com.exercise.security.model.SysUserTypeExample;

import java.util.List;

public interface UserTypeService {

    long countByExample(SysUserTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysUserType record);

    List<SysUserType> selectByExample(SysUserTypeExample example);

    SysUserType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserType record);

    ResultDTO<SysUserType> getPage(RequestDTO<SysUserType> params);

    SysUserTypeExample setCondition(SysUserType filter);
}
