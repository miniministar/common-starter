package com.exercise.security.controller;


import com.exercise.security.service.SystemUserService;
import com.exercise.security.service.UserTypeService;
import com.exercise.common.core.annotation.MyLog;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.enums.BusinessType;
import com.exercise.security.model.SysUserExample;
import com.exercise.security.model.SysUserType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/type/", method = RequestMethod.POST)
@Api(tags = {"用户权限中心 - 用户分组管理"})
public class UserTypeController {

    @Autowired
    private UserTypeService service;
    @Autowired
    private SystemUserService systemUserService;

    @MyLog(title = "用户分组管理", businessType = BusinessType.INSERT)
    @RequestMapping("add")
    @ApiOperation(value="添加", notes="添加用户分组信息")
    public CommonResult add(@RequestBody SysUserType entity){
        int result = service.insertSelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取用户分组信息")
    public CommonResult<SysUserType> get(Long id) {
        SysUserType entity = service.selectByPrimaryKey(id);
        return CommonResult.success(entity);
    }

    @MyLog(title = "用户分组管理", businessType = BusinessType.UPDATE)
    @RequestMapping("update")
    @ApiOperation(value="修改信息", notes="修改用户分组信息")
    public CommonResult update(@RequestBody SysUserType entity){
        int result  = service.updateByPrimaryKeySelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysUserType> getList(@RequestBody RequestDTO<SysUserType> params) {
        return service.getPage(params);
    }

    @MyLog(title = "用户分组管理", businessType = BusinessType.DELETE)
    @RequestMapping("delete")
    @ApiOperation(value="删除",notes="删除")
    public CommonResult delete(Long id){
        SysUserExample userExample = new SysUserExample();
        SysUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserTypeIdEqualTo(id);
        long count = systemUserService.countByExample(userExample);
        if(count > 0) {
            return CommonResult.failed("用户存在该分组，不能删除");
        }

        int success = service.deleteByPrimaryKey(id);
        return CommonResult.success(success);
    }

}
