package com.exercise.security.mapper;

import com.exercise.security.model.SysNotice;
import com.exercise.security.model.SysNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNoticeMapper {
    long countByExample(SysNoticeExample example);

    int deleteByExample(SysNoticeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    List<SysNotice> selectByExampleWithBLOBs(SysNoticeExample example);

    List<SysNotice> selectByExample(SysNoticeExample example);

    SysNotice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByExample(@Param("record") SysNotice record, @Param("example") SysNoticeExample example);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByPrimaryKeyWithBLOBs(SysNotice record);

    int updateByPrimaryKey(SysNotice record);
}