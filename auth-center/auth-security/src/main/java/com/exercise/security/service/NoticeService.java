package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.model.SysNotice;
import com.exercise.security.model.SysNoticeExample;

import java.util.List;

public interface NoticeService {

    long countByExample(SysNoticeExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysNotice record);

    List<SysNotice> selectByExample(SysNoticeExample example);

    List<SysNotice> selectByExampleWithBLOBs(SysNoticeExample example);

    SysNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysNotice record);

    ResultDTO<SysNotice> getPage(RequestDTO<SysNotice> params);

    SysNoticeExample setCondition(SysNotice filter);
}
