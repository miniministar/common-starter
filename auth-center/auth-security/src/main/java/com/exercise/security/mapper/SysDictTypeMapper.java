package com.exercise.security.mapper;

import com.exercise.security.model.SysDictType;
import com.exercise.security.model.SysDictTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictTypeMapper {
    long countByExample(SysDictTypeExample example);

    int deleteByExample(SysDictTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDictType record);

    int insertSelective(SysDictType record);

    List<SysDictType> selectByExample(SysDictTypeExample example);

    SysDictType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    int updateByExample(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    int updateByPrimaryKeySelective(SysDictType record);

    int updateByPrimaryKey(SysDictType record);
}