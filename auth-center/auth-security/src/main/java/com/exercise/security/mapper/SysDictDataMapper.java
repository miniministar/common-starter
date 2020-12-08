package com.exercise.security.mapper;

import com.exercise.security.model.SysDictData;
import com.exercise.security.model.SysDictDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictDataMapper {
    long countByExample(SysDictDataExample example);

    int deleteByExample(SysDictDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDictData record);

    int insertSelective(SysDictData record);

    List<SysDictData> selectByExample(SysDictDataExample example);

    SysDictData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDictData record, @Param("example") SysDictDataExample example);

    int updateByExample(@Param("record") SysDictData record, @Param("example") SysDictDataExample example);

    int updateByPrimaryKeySelective(SysDictData record);

    int updateByPrimaryKey(SysDictData record);
}