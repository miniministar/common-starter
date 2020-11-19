package com.exercise.doc.mapper;

import com.exercise.doc.model.Apilog;
import com.exercise.doc.model.ApilogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApilogMapper {
    long countByExample(ApilogExample example);

    int deleteByExample(ApilogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Apilog record);

    int insertSelective(Apilog record);

    List<Apilog> selectByExampleWithBLOBs(ApilogExample example);

    List<Apilog> selectByExample(ApilogExample example);

    Apilog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Apilog record, @Param("example") ApilogExample example);

    int updateByExampleWithBLOBs(@Param("record") Apilog record, @Param("example") ApilogExample example);

    int updateByExample(@Param("record") Apilog record, @Param("example") ApilogExample example);

    int updateByPrimaryKeySelective(Apilog record);

    int updateByPrimaryKeyWithBLOBs(Apilog record);

    int updateByPrimaryKey(Apilog record);
}