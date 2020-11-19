package com.exercise.oauth2.mapper;

import com.exercise.oauth2.model.OauthApiLog;
import com.exercise.oauth2.model.OauthApiLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthApiLogMapper {
    long countByExample(OauthApiLogExample example);

    int deleteByExample(OauthApiLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OauthApiLog record);

    int insertSelective(OauthApiLog record);

    List<OauthApiLog> selectByExampleWithBLOBs(OauthApiLogExample example);

    List<OauthApiLog> selectByExample(OauthApiLogExample example);

    OauthApiLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OauthApiLog record, @Param("example") OauthApiLogExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthApiLog record, @Param("example") OauthApiLogExample example);

    int updateByExample(@Param("record") OauthApiLog record, @Param("example") OauthApiLogExample example);

    int updateByPrimaryKeySelective(OauthApiLog record);

    int updateByPrimaryKeyWithBLOBs(OauthApiLog record);

    int updateByPrimaryKey(OauthApiLog record);
}