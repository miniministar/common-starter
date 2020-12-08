package com.exercise.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.mapper.SysDictDataMapper;
import com.exercise.security.model.SysDictData;
import com.exercise.security.model.SysDictDataExample;
import com.exercise.security.service.DictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DictDataServiceImpl implements DictDataService {

    @Autowired
    private SysDictDataMapper mapper;

    @Override
    public long countByExample(SysDictDataExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysDictData record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysDictData> selectByExample(SysDictDataExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysDictData selectByPrimaryKey(Long id) {
        SysDictData row = mapper.selectByPrimaryKey(id);
        return row;
    }

    @Override
    public int updateByPrimaryKeySelective(SysDictData record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysDictData> getPage(RequestDTO<SysDictData> params) {
        SysDictData filter = params.getFilter();
        SysDictDataExample example = setCondition(filter);

        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        List<SysDictData> list = mapper.selectByExample(example);
        ResultDTO<SysDictData> page = ResultDTO.restPage(list);

        return page;
    }

    @Override
    public SysDictDataExample setCondition(SysDictData filter) {
        SysDictDataExample example = new SysDictDataExample();
        SysDictDataExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( !StringUtils.isEmpty(filter.getDictName()) ) {
                criteria.andDictNameLike("%" + filter.getDictName()+ "%");
            }
            if( !StringUtils.isEmpty(filter.getDictCode()) ) {
                criteria.andDictCodeEqualTo( filter.getDictCode() );
            }
            if( !StringUtils.isEmpty(filter.getDictType()) ) {
                criteria.andDictTypeEqualTo( filter.getDictType() );
            }
            if(!StringUtils.isEmpty(filter.getStatus() )) {
                criteria.andStatusEqualTo(filter.getStatus());
            }
        }
        example.setOrderByClause("dict_sort asc");
        return example;
    }

    @Override
    public long countDictType(String dictType) {
        SysDictDataExample example = new SysDictDataExample();
        SysDictDataExample.Criteria criteria = example.createCriteria();
        criteria.andDictTypeEqualTo(dictType);
        return mapper.countByExample(example);
    }
}
