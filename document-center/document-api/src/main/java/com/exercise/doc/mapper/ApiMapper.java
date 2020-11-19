package com.exercise.doc.mapper;

import com.exercise.doc.model.Api;
import com.exercise.doc.model.ApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApiMapper {
    long countByExample(ApiExample example);

    int deleteByExample(ApiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Api record);

    int insertSelective(Api record);

    List<Api> selectByExampleWithBLOBs(ApiExample example);

    List<Api> selectByExample(ApiExample example);

    Api selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByExampleWithBLOBs(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByExample(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByPrimaryKeySelective(Api record);

    int updateByPrimaryKeyWithBLOBs(Api record);

    int updateByPrimaryKey(Api record);
}