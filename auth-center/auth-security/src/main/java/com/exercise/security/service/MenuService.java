package com.exercise.security.service;

import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.security.model.SysMenu;
import com.exercise.security.model.SysMenuExample;

import java.util.List;

public interface MenuService {

    long countByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    ResultDTO<SysMenu> getPage(RequestDTO<SysMenu> params);

    SysMenuExample setCondition(SysMenu filter);

    long countChildMenu(Long parentId);

    List<SysMenu> selectTree(RequestDTO<SysMenu> params);

    List<SysMenu> constructTree(List<SysMenu> list);
}
