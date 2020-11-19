package com.exercise.security.controller;


import com.exercise.security.service.RoleService;
import com.exercise.security.service.RoleUserService;
import com.exercise.common.core.annotation.MyLog;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.enums.BusinessType;
import com.exercise.common.core.validator.Create;
import com.exercise.common.core.validator.Update;
import com.exercise.security.model.SysRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/role/", method = RequestMethod.POST)
@Api(tags = {"用户权限中心 - 角色管理"})
public class RoleController {

    @Autowired
    private RoleService service;
    @Autowired
    private RoleUserService roleUserService;

    @MyLog(title = "角色管理", businessType = BusinessType.INSERT)
    @RequestMapping("add")
    @ApiOperation(value="添加", notes="添加角色信息")
    public CommonResult add(@RequestBody @Validated({Create.class}) SysRole entity){
        int result = service.insertSelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取角色信息")
    public CommonResult<SysRole> get(Long id) {
        SysRole entity = service.selectByPrimaryKey(id);
        return CommonResult.success(entity);
    }

    @MyLog(title = "角色管理", businessType = BusinessType.UPDATE)
    @RequestMapping("update")
    @ApiOperation(value="修改信息", notes="修改角色信息")
    public CommonResult update(@RequestBody @Validated({Update.class}) SysRole entity){
        int result  = service.updateByPrimaryKeySelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysRole> getList(@RequestBody RequestDTO<SysRole> params) {
        return service.getPage(params);
    }

    @MyLog(title = "角色管理", businessType = BusinessType.DELETE)
    @RequestMapping("delete")
    @ApiOperation(value="删除",notes="删除")
    public CommonResult delete(Long id){
        long count = roleUserService.countRoleUser(id);
        if(count > 0) {
            return CommonResult.failed("有该角色的用户，不能删除");
        }

        int success = service.deleteByPrimaryKey(id);
        return CommonResult.success(success);
    }

    @RequestMapping("setMenu")
    @ApiOperation(value="关联权限",notes="设置 角色id, menus -> id")
    public CommonResult setMenu(@RequestBody SysRole entity) {
        int i = service.setMenu(entity);
        return CommonResult.success(i);
    }

}
