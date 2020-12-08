package com.exercise.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.exception.ApiException;
import com.exercise.security.mapper.SysDictTypeMapper;
import com.exercise.security.model.SysDictType;
import com.exercise.security.model.SysDictTypeExample;
import com.exercise.security.service.DictDataService;
import com.exercise.security.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DictTypeServiceImpl implements DictTypeService {

    @Autowired
    private SysDictTypeMapper mapper;
    @Autowired
    private DictDataService dataService;

    @Override
    public long countByExample(SysDictTypeExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        SysDictType dictType = mapper.selectByPrimaryKey(id);
        long count = dataService.countDictType(dictType.getDictType());
        if(count > 0) throw new ApiException("请先删除该字典的数据");

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysDictType record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysDictType> selectByExample(SysDictTypeExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysDictType selectByPrimaryKey(Long id) {
        SysDictType row = mapper.selectByPrimaryKey(id);
        return row;
    }

    @Override
    public int updateByPrimaryKeySelective(SysDictType record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysDictType> getPage(RequestDTO<SysDictType> params) {
        SysDictType filter = params.getFilter();
        SysDictTypeExample example = setCondition(filter);

        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        List<SysDictType> list = mapper.selectByExample(example);
        ResultDTO<SysDictType> page = ResultDTO.restPage(list);

        return page;
    }

    @Override
    public SysDictTypeExample setCondition(SysDictType filter) {
        SysDictTypeExample example = new SysDictTypeExample();
        SysDictTypeExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( !StringUtils.isEmpty(filter.getDictName()) ) {
                criteria.andDictNameLike("%" + filter.getDictName()+ "%");
            }
            if( !StringUtils.isEmpty(filter.getDictType()) ) {
                criteria.andDictTypeLike("%" + filter.getDictType()+ "%");
            }
            if(!StringUtils.isEmpty(filter.getStatus() )) {
                criteria.andStatusEqualTo(filter.getStatus());
            }
        }
        example.setOrderByClause("id desc");
        return example;
    }
}
