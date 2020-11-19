package com.exercise.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.exception.ApiException;
import com.exercise.security.mapper.SysOperLogMapper;
import com.exercise.security.model.SysOperLog;
import com.exercise.security.model.SysOperLogExample;
import com.exercise.security.service.OperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class OperLogServiceImpl implements OperLogService {
    @Autowired
    private SysOperLogMapper mapper;

    @Override
    public long countByExample(SysOperLogExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysOperLog record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysOperLog> selectByExample(SysOperLogExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysOperLog selectByPrimaryKey(Long id) {
        SysOperLog row = mapper.selectByPrimaryKey(id);
        return row;
    }

    @Override
    public int updateByPrimaryKeySelective(SysOperLog record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysOperLog> getPage(RequestDTO<SysOperLog> params) {
        SysOperLog filter = params.getFilter();
        SysOperLogExample example = setCondition(filter);

        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        List<SysOperLog> list = selectByExample(example);
        ResultDTO<SysOperLog> page = ResultDTO.restPage(list);

        return page;
    }

    @Override
    public SysOperLogExample setCondition(SysOperLog filter) {
        SysOperLogExample example = new SysOperLogExample();
        SysOperLogExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( !StringUtils.isEmpty(filter.getUsername()) ) {
                criteria.andUsernameLike("%" + filter.getUsername() + "%");
            }
            if( !StringUtils.isEmpty(filter.getUserRealName()) ) {
                criteria.andUserRealNameLike("%" +filter.getUserRealName()+ "%");
            }
            if( !StringUtils.isEmpty(filter.getStartDay()) ) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    criteria.andOperTimeGreaterThanOrEqualTo(df.parse(filter.getStartDay() + " 00:00:00"));
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new ApiException("日期格式错误");
                }
            }
            if( !StringUtils.isEmpty(filter.getEndDay()) ) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    criteria.andOperTimeLessThanOrEqualTo(df.parse(filter.getEndDay() + " 23:59:59"));
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new ApiException("日期格式错误");
                }
            }
        }
        return example;
    }

    @Override
    public List<SysOperLog> getList(SysOperLog filter) {
        SysOperLogExample example = setCondition(filter);
        return selectByExample(example);
    }
}
