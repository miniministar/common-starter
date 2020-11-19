package com.exercise.system.controller;


import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.oauth2.model.SysUser;
import com.exercise.system.service.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("add")
    @ApiOperation(value="添加", notes="添加应用信息")
    public CommonResult add(@RequestBody SysUser entity){
        int result = service.insertSelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取应用信息")
    public CommonResult<SysUser> get(Long id) {
        SysUser devInfo = service.selectByPrimaryKey(id);
        return CommonResult.success(devInfo);
    }

    @RequestMapping("update")
    @ApiOperation(value="修改信息", notes="修改应用信息")
    public CommonResult update(@RequestBody SysUser entity){
        int result  = service.updateByPrimaryKeySelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysUser> getList(@RequestBody RequestDTO<SysUser> params) {
        return service.getPage(params);
    }

    @RequestMapping("delete")
    @ApiOperation(value="删除",notes="删除")
    public CommonResult delete(Long id){
        int success = service.deleteByPrimaryKey(id);
        return CommonResult.success(success);
    }

}
