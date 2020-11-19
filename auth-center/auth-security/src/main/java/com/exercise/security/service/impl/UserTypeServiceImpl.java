package com.exercise.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.mapper.SysUserTypeMapper;
import com.exercise.security.model.SysUserType;
import com.exercise.security.model.SysUserTypeExample;
import com.exercise.security.service.SystemUserService;
import com.exercise.security.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private SysUserTypeMapper mapper;
    @Autowired
    private SystemUserService systemUserService;

    @Override
    public long countByExample(SysUserTypeExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysUserType record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysUserType> selectByExample(SysUserTypeExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysUserType selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUserType record) {
        systemUserService.updateUserType(record);
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysUserType> getPage(RequestDTO<SysUserType> params) {
        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        SysUserType filter = params.getFilter();
        SysUserTypeExample example = setCondition(filter);
        List<SysUserType> list = selectByExample(example);
        ResultDTO<SysUserType> page = ResultDTO.restPage(list);
        return page;
    }

    @Override
    public SysUserTypeExample setCondition(SysUserType filter) {
        SysUserTypeExample example = new SysUserTypeExample();
        SysUserTypeExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( !StringUtils.isEmpty(filter.getType()) ) {
                criteria.andTypeLike(filter.getType());
            }
        }
        return example;
    }
}
