package com.exercise.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exercise.security.model.SysRole;
import com.exercise.security.model.SysRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}