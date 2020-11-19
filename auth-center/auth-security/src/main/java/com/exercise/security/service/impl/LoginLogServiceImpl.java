package com.exercise.security.service.impl;

import com.exercise.security.service.LoginLogService;
import com.github.pagehelper.PageHelper;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.exception.ApiException;
import com.exercise.security.mapper.SysLoginLogMapper;
import com.exercise.security.model.SysLoginLog;
import com.exercise.security.model.SysLoginLogExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private SysLoginLogMapper mapper;

    @Override
    public long countByExample(SysLoginLogExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysLoginLog record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysLoginLog> selectByExample(SysLoginLogExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysLoginLog selectByPrimaryKey(Long id) {
        SysLoginLog row = mapper.selectByPrimaryKey(id);
        return row;
    }

    @Override
    public int updateByPrimaryKeySelective(SysLoginLog record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysLoginLog> getPage(RequestDTO<SysLoginLog> params) {
        SysLoginLog filter = params.getFilter();
        SysLoginLogExample example = setCondition(filter);

        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        List<SysLoginLog> list = selectByExample(example);
        ResultDTO<SysLoginLog> page = ResultDTO.restPage(list);

        return page;
    }

    @Override
    public SysLoginLogExample setCondition(SysLoginLog filter) {
        SysLoginLogExample example = new SysLoginLogExample();
        SysLoginLogExample.Criteria criteria = example.createCriteria();
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
                    criteria.andLoginTimeGreaterThanOrEqualTo(df.parse(filter.getStartDay() + " 00:00:00"));
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new ApiException("日期格式错误");
                }
            }
            if( !StringUtils.isEmpty(filter.getEndDay()) ) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    criteria.andLoginTimeLessThanOrEqualTo(df.parse(filter.getEndDay() + " 23:59:59"));
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new ApiException("日期格式错误");
                }
            }
        }
        return example;
    }

    @Override
    public List<SysLoginLog> getList(SysLoginLog filter) {
        SysLoginLogExample example = setCondition(filter);
        return selectByExample(example);
    }
}
