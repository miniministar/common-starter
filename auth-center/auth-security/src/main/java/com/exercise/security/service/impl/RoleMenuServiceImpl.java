package com.exercise.security.service.impl;

import com.exercise.security.service.RoleMenService;
import com.exercise.security.service.SystemUserService;
import com.github.pagehelper.PageHelper;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.mapper.SysRoleMenuMapper;
import com.exercise.security.model.SysRoleMenu;
import com.exercise.security.model.SysRoleMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenService {

    @Autowired
    private SysRoleMenuMapper mapper;
    @Autowired
    private SystemUserService systemUserService;

    @Override
    public long countByExample(SysRoleMenuExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(SysRoleMenuExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int insert(SysRoleMenu record) {
        return mapper.insert(record);
    }

    @Override
    public List<SysRoleMenu> selectByExample(SysRoleMenuExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysRoleMenu selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRoleMenu record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysRoleMenu> getPage(RequestDTO<SysRoleMenu> params) {
        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        SysRoleMenu filter = params.getFilter();
        SysRoleMenuExample example = setCondition(filter);
        List<SysRoleMenu> list = selectByExample(example);
        ResultDTO<SysRoleMenu> page = ResultDTO.restPage(list);
        return page;
    }

    @Override
    public SysRoleMenuExample setCondition(SysRoleMenu filter) {
        SysRoleMenuExample example = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( filter.getRoleId() != null ) {
                criteria.andRoleIdEqualTo(filter.getRoleId());
            }
        }
        return example;
    }

    @Override
    public int deleteByRoleId(Long roleId) {
        SysRoleMenuExample example = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return deleteByExample(example);
    }

    @Override
    public long countRoleMenu(Long roleId) {
        SysRoleMenuExample example = new SysRoleMenuExample();
        SysRoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return countByExample(example);
    }
}
