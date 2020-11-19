package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.model.SysOperLog;
import com.exercise.security.model.SysOperLogExample;

import java.util.List;

public interface OperLogService {

    long countByExample(SysOperLogExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysOperLog record);

    List<SysOperLog> selectByExample(SysOperLogExample example);

    SysOperLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysOperLog record);

    ResultDTO<SysOperLog> getPage(RequestDTO<SysOperLog> params);

    SysOperLogExample setCondition(SysOperLog filter);

    List<SysOperLog> getList(SysOperLog filter);
}
