package com.exercise.security.controller;


import com.exercise.security.service.MenuService;
import com.exercise.security.service.RoleMenService;
import com.exercise.common.core.annotation.MyLog;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.enums.BusinessType;
import com.exercise.security.model.SysMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/menu/", method = RequestMethod.POST)
@Api(tags = {"用户权限中心 - 权限管理"})
public class MenuController {

    @Autowired
    private MenuService service;
    @Autowired
    private RoleMenService roleMenService;

    @MyLog(title = "权限管理", businessType = BusinessType.INSERT)
    @RequestMapping("add")
    @ApiOperation(value="添加", notes="添加权限信息")
    public CommonResult add(@RequestBody SysMenu entity){
        int result = service.insertSelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取权限信息")
    public CommonResult<SysMenu> get(Long id) {
        SysMenu entity = service.selectByPrimaryKey(id);
        return CommonResult.success(entity);
    }

    @MyLog(title = "权限管理", businessType = BusinessType.UPDATE)
    @RequestMapping("update")
    @ApiOperation(value="修改信息", notes="修改权限信息")
    public CommonResult update(@RequestBody SysMenu entity){
        int result  = service.updateByPrimaryKeySelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysMenu> list(@RequestBody RequestDTO<SysMenu> params) {
        return service.getPage(params);
    }

    @MyLog(title = "权限管理", businessType = BusinessType.DELETE)
    @RequestMapping("delete")
    @ApiOperation(value="删除",notes="删除")
    public CommonResult delete(Long id){
        long count = roleMenService.countRoleMenu(id);
        if(count > 0) {
            return CommonResult.failed("有该权限的角色，不能删除");
        }

        count = service.countChildMenu(id);
        if(count > 0) {
            return CommonResult.failed("请先删除下级");
        }

        int success = service.deleteByPrimaryKey(id);
        return CommonResult.success(success);
    }

    @RequestMapping("tree")
    @ApiOperation(value="权限树",notes="")
    public CommonResult<List<SysMenu>> tree(@RequestBody RequestDTO<SysMenu> params) {
        List<SysMenu> list = service.selectTree(params);
        return CommonResult.success(list);
    }
}
