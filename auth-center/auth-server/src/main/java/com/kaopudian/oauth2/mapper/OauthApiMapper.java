package com.exercise.oauth2.mapper;

import com.exercise.oauth2.model.OauthApi;
import com.exercise.oauth2.model.OauthApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthApiMapper {
    long countByExample(OauthApiExample example);

    int deleteByExample(OauthApiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OauthApi record);

    int insertSelective(OauthApi record);

    List<OauthApi> selectByExample(OauthApiExample example);

    OauthApi selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OauthApi record, @Param("example") OauthApiExample example);

    int updateByExample(@Param("record") OauthApi record, @Param("example") OauthApiExample example);

    int updateByPrimaryKeySelective(OauthApi record);

    int updateByPrimaryKey(OauthApi record);
}