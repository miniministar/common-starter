package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.model.SysDictType;
import com.exercise.security.model.SysDictTypeExample;

import java.util.List;

public interface DictTypeService {

    long countByExample(SysDictTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysDictType record);

    List<SysDictType> selectByExample(SysDictTypeExample example);

    SysDictType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDictType record);

    ResultDTO<SysDictType> getPage(RequestDTO<SysDictType> params);

    SysDictTypeExample setCondition(SysDictType filter);
}
