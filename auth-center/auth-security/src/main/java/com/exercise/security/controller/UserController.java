package com.exercise.security.controller;


import com.exercise.common.core.annotation.MyLog;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.enums.BusinessType;
import com.exercise.common.core.validator.Create;
import com.exercise.common.core.validator.Update;
import com.exercise.security.dto.UserPasswordPara;
import com.exercise.security.model.SysUser;
import com.exercise.security.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/", method = RequestMethod.POST)
@Api(tags = {"用户权限中心 - 用户管理"})
public class UserController {

    @Autowired
    private SystemUserService service;

    @MyLog(title = "用户管理", businessType = BusinessType.INSERT)
    @RequestMapping("add")
    @ApiOperation(value="添加", notes="添加用户信息")
    public CommonResult add(@RequestBody @Validated({Create.class}) SysUser entity){
        int result = service.insertSelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取用户信息")
    public CommonResult<SysUser> get(Long id) {
        SysUser entity = service.selectByPrimaryKey(id);
        return CommonResult.success(entity);
    }

    @MyLog(title = "用户管理", businessType = BusinessType.UPDATE)
    @RequestMapping("update")
    @ApiOperation(value="修改信息", notes="修改用户信息")
    public CommonResult update(@RequestBody @Validated({Update.class}) SysUser entity){
        int result  = service.updateByPrimaryKeySelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysUser> getList(@RequestBody RequestDTO<SysUser> params) {
        return service.getPage(params);
    }

    @MyLog(title = "用户管理", businessType = BusinessType.DELETE)
    @RequestMapping("delete")
    @ApiOperation(value="删除",notes="删除")
    public CommonResult delete(Long id){
        int success = service.deleteByPrimaryKey(id);
        return CommonResult.success(success);
    }

    @RequestMapping("getInitInfo")
    @ApiOperation(value="获取系统初始化信息", notes="用户信息和菜单")
    public CommonResult<SysUser> getInitInfo(){
        SysUser currentUser = service.getInitInfo();
        return CommonResult.success(currentUser);
    }


    @RequestMapping(value = "resetPassword")
    @ApiOperation(value = "重置密码")
    public CommonResult resetPassword(String username) {
        service.resetPassword(username);
        return CommonResult.success("重置成功");
    }

    @RequestMapping(value = "changePassword")
    @ApiOperation(value = "修改密码", httpMethod = "POST")
    public CommonResult changePassword(@RequestBody @Validated UserPasswordPara input) {
        service.changePassword(input);
        return CommonResult.success("修改成功");
    }

    @RequestMapping("refreshToken")
    @ApiOperation(value="刷新token", notes="")
    public CommonResult<SysUser> refreshToken(){
        SysUser currentUser = service.refreshToken();
        return CommonResult.success(currentUser);
    }
}
