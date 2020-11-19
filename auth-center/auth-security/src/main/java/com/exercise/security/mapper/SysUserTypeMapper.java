package com.exercise.security.mapper;

import com.exercise.security.model.SysUserType;
import com.exercise.security.model.SysUserTypeExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserTypeMapper {
    long countByExample(SysUserTypeExample example);

    int deleteByExample(SysUserTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserType record);

    int insertSelective(SysUserType record);

    List<SysUserType> selectByExample(SysUserTypeExample example);

    SysUserType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserType record, @Param("example") SysUserTypeExample example);

    int updateByExample(@Param("record") SysUserType record, @Param("example") SysUserTypeExample example);

    int updateByPrimaryKeySelective(SysUserType record);

    int updateByPrimaryKey(SysUserType record);
}