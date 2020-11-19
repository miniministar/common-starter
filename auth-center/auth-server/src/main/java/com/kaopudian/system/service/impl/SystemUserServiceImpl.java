package com.exercise.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.oauth2.mapper.SysUserMapper;
import com.exercise.oauth2.model.SysUser;
import com.exercise.oauth2.model.SysUserExample;
import com.exercise.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    private SysUserMapper mapper;

    @Override
    public long countByExample(SysUserExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysUser record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysUser> selectByExample(SysUserExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysUser selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysUser> getPage(RequestDTO<SysUser> params) {
        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        SysUser filter = params.getFilter();
        SysUserExample example = setCondition(filter);
        List<SysUser> list = selectByExample(example);
        ResultDTO<SysUser> devSensorResultDTO = ResultDTO.restPage(list);
        return devSensorResultDTO;
    }

    @Override
    public SysUserExample setCondition(SysUser filter) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( filter.getId() != null ) {
                criteria.andIdEqualTo(filter.getId() );
            }
            if( !StringUtils.isEmpty(filter.getFullname()) ) {
                criteria.andFullnameLike(filter.getFullname());
            }
            if( !StringUtils.isEmpty(filter.getUsername()) ) {
                criteria.andUsernameLike("%" + filter.getUsername() + "%");
            }
        }
        return example;
    }
}
