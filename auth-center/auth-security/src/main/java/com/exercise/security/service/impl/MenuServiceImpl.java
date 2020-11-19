package com.exercise.security.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.exercise.security.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.mapper.SysMenuMapper;
import com.exercise.security.model.SysMenu;
import com.exercise.security.model.SysMenuExample;
import com.exercise.security.util.MenuTreeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private SysMenuMapper mapper;

    @Override
    public long countByExample(SysMenuExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SysMenu> selectByExample(SysMenuExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public SysMenu selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResultDTO<SysMenu> getPage(RequestDTO<SysMenu> params) {
        PageHelper.startPage(params.getCurrentPageNum(), params.getLength());
        SysMenu filter = params.getFilter();
        SysMenuExample example = setCondition(filter);
        List<SysMenu> list = selectByExample(example);
        ResultDTO<SysMenu> page = ResultDTO.restPage(list);
        return page;
    }

    @Override
    public SysMenuExample setCondition(SysMenu filter) {
        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        //设置条件
        if(filter!=null) {
            if( filter.getParentId() != null ) {
                criteria.andParentIdEqualTo(filter.getParentId());
            }
            if( !StringUtils.isEmpty(filter.getName()) ) {
                criteria.andNameLike("%" + filter.getName() + "%");
            }
        }
        example.setOrderByClause("sort asc");
        return example;
    }

    @Override
    public long countChildMenu(Long parentId) {
        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return countByExample(example);
    }

    @Override
    public List<SysMenu> selectTree(RequestDTO<SysMenu> params) {

        SysMenuExample example = setCondition(params.getFilter());
        List<SysMenu> list = selectByExample(example);
        return constructTree(list);
    }

    @Override
    public List<SysMenu> constructTree(List<SysMenu> list) {
        List<SysMenu> menuTreeNodeList = Lists.newArrayList();
        if( list != null && !list.isEmpty() ){
            list.forEach( temp->{
                SysMenu menuTreeNode = new SysMenu();
                BeanUtil.copyProperties( temp, menuTreeNode);
                menuTreeNodeList.add( menuTreeNode );
            } );
        }
        List<SysMenu> menuTreeNodeList2 = MenuTreeBuilder.buildMenuTree( menuTreeNodeList );
        menuTreeNodeList2.stream().sorted(Comparator.comparing(SysMenu::getSort)).collect(Collectors.toList());
        return menuTreeNodeList2;
    }
}
