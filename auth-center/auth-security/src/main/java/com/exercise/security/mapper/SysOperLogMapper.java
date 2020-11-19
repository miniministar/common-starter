package com.exercise.security.mapper;

import com.exercise.security.model.SysOperLog;
import com.exercise.security.model.SysOperLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOperLogMapper {
    long countByExample(SysOperLogExample example);

    int deleteByExample(SysOperLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysOperLog record);

    int insertSelective(SysOperLog record);

    List<SysOperLog> selectByExample(SysOperLogExample example);

    SysOperLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysOperLog record, @Param("example") SysOperLogExample example);

    int updateByExample(@Param("record") SysOperLog record, @Param("example") SysOperLogExample example);

    int updateByPrimaryKeySelective(SysOperLog record);

    int updateByPrimaryKey(SysOperLog record);
}