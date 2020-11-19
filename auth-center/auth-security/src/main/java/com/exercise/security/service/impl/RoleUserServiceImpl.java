package com.exercise.security.service.impl;

import com.exercise.security.model.*;
import com.exercise.security.service.RoleService;
import com.exercise.security.mapper.SysRoleUserMapper;
import com.exercise.security.model.*;
import com.exercise.security.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private SysRoleUserMapper mapper;
    @Autowired
    private RoleService roleService;

    @Override
    public int insert(SysRoleUser record) {
        return mapper.insert(record);
    }

    @Override
    public int deleteByExample(SysRoleUserExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public void setUserRole(SysUser user, List<SysRole> roles) {
        if(!CollectionUtils.isEmpty(roles) && user.getId()!=null) {
            deleteUserAllRole(user);
            for (SysRole role: roles ) {
                SysRoleUser roleUser = new SysRoleUser();
                roleUser.setUserId(user.getId());
                roleUser.setRoleId(role.getId());
                insert(roleUser);
            }
        }
    }

    public int deleteUserAllRole(SysUser user) {
        SysRoleUserExample example = new SysRoleUserExample();
        SysRoleUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        return deleteByExample(example);
    }

    @Override
    public List<SysRole> getUserAllRole(Long userId) {
        if(userId!=null) {
            SysRoleUserExample example = new SysRoleUserExample();
            SysRoleUserExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<SysRoleUser> sysRoleUsers = selectByExample(example);
            if(CollectionUtils.isEmpty(sysRoleUsers)) return null;

            List<Long> collect = sysRoleUsers.stream().map(SysRoleUser::getRoleId).collect(Collectors.toList());
            SysRoleExample roleExample = new SysRoleExample();
            SysRoleExample.Criteria roleExampleCriteria = roleExample.createCriteria();
            if(collect.size() > 1) {
                roleExampleCriteria.andIdIn(collect);
            }else {
                roleExampleCriteria.andIdEqualTo(collect.get(0));
            }
            List<SysRole> sysRoles = roleService.selectByExample(roleExample);
            return sysRoles;
        }
        return null;
    }

    @Override
    public List<SysRoleUser> selectByExample(SysRoleUserExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public long countByExample(SysRoleUserExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public long countRoleUser(Long roleId) {
        SysRoleUserExample example = new SysRoleUserExample();
        SysRoleUserExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return countByExample(example);
    }
}
