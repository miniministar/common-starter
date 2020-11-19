package com.exercise.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.exception.ApiException;
import com.exercise.security.mapper.SysNoticeMapper;
import com.exercise.security.model.SysNotice;
import com.exercise.security.model.SysNoticeExample;
import com.exercise.security.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private SysNoticeMapper mapper;

    @Override
    public long countByExample(SysNoticeExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysNotice record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysNotice> selectByExample(SysNoticeExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<SysNotice> selectByExampleWithBLOBs(SysNoticeExample example) {
        return mapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public SysNotice selectByPrimaryKey(Long id) {
        SysNotice row = mapper.selectByPrimaryKey(id);
        return row;
    }

    @Override
    public int updateByPrimaryKeySelective(SysNotice record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysNotice> getPage(RequestDTO<SysNotice> params) {
        SysNotice filter = params.getFilter();
        SysNoticeExample example = setCondition(filter);

        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        List<SysNotice> list = selectByExampleWithBLOBs(example);
        ResultDTO<SysNotice> page = ResultDTO.restPage(list);

        return page;
    }

    @Override
    public SysNoticeExample setCondition(SysNotice filter) {
        SysNoticeExample example = new SysNoticeExample();
        SysNoticeExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( !StringUtils.isEmpty(filter.getNoticeTitle()) ) {
                criteria.andNoticeTitleLike("%" + filter.getNoticeTitle()+ "%");
            }
            if( !StringUtils.isEmpty(filter.getPublishDay()) ) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    criteria.andModifyTimeBetween(df.parse(filter.getPublishDay() + " 00:00:00"), df.parse(filter.getPublishDay() + " 23:59:59"));
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new ApiException("日期格式错误");
                }
            }
            if(filter.getTags()!=null) {
                criteria.andTagsEqualTo(filter.getTags());
            }
            if(filter.getNoticeType()!=null) {
                criteria.andNoticeTypeEqualTo(filter.getNoticeType());
            }
        }
        example.setOrderByClause("id desc");
        return example;
    }
}
