package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.model.SysLoginLog;
import com.exercise.security.model.SysLoginLogExample;

import java.util.List;

public interface LoginLogService {

    long countByExample(SysLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysLoginLog record);

    List<SysLoginLog> selectByExample(SysLoginLogExample example);

    SysLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLoginLog record);

    ResultDTO<SysLoginLog> getPage(RequestDTO<SysLoginLog> params);

    SysLoginLogExample setCondition(SysLoginLog filter);

    List<SysLoginLog> getList(SysLoginLog filter);
}
