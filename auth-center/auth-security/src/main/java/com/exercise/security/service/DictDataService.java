package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.model.SysDictData;
import com.exercise.security.model.SysDictDataExample;

import java.util.List;

public interface DictDataService {

    long countByExample(SysDictDataExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysDictData record);

    List<SysDictData> selectByExample(SysDictDataExample example);

    SysDictData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDictData record);

    ResultDTO<SysDictData> getPage(RequestDTO<SysDictData> params);

    SysDictDataExample setCondition(SysDictData filter);

    long countDictType(String dictType);
}
