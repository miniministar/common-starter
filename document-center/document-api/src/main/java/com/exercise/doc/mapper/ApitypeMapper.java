package com.exercise.doc.mapper;

import com.exercise.doc.model.Apitype;
import com.exercise.doc.model.ApitypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApitypeMapper {
    long countByExample(ApitypeExample example);

    int deleteByExample(ApitypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Apitype record);

    int insertSelective(Apitype record);

    List<Apitype> selectByExample(ApitypeExample example);

    Apitype selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Apitype record, @Param("example") ApitypeExample example);

    int updateByExample(@Param("record") Apitype record, @Param("example") ApitypeExample example);

    int updateByPrimaryKeySelective(Apitype record);

    int updateByPrimaryKey(Apitype record);
}