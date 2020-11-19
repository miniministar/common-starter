package com.exercise.oauth2.mapper;

import com.exercise.oauth2.model.SysRoleUser;
import com.exercise.oauth2.model.SysRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleUserMapper {
    long countByExample(SysRoleUserExample example);

    int deleteByExample(SysRoleUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    List<SysRoleUser> selectByExample(SysRoleUserExample example);

    SysRoleUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByExample(@Param("record") SysRoleUser record, @Param("example") SysRoleUserExample example);

    int updateByPrimaryKeySelective(SysRoleUser record);

    int updateByPrimaryKey(SysRoleUser record);
}