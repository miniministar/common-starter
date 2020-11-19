package com.exercise.oauth2.service;

import com.exercise.oauth2.model.SysUser;
import com.exercise.oauth2.model.SysUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    SysUser selectByUsername(String username);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    List<String> findPermissionByUserId(Long id);

}
