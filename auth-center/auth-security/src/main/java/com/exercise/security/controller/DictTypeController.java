package com.exercise.security.controller;


import com.exercise.common.core.annotation.MyLog;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.enums.BusinessType;
import com.exercise.common.core.validator.Create;
import com.exercise.common.core.validator.Update;
import com.exercise.security.model.SysDictType;
import com.exercise.security.service.DictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dict/type", method = RequestMethod.POST)
@Api(tags = {"系统管理中心 - 字典管理"})
public class DictTypeController {

    @Autowired
    private DictTypeService service;

    @MyLog(title = "字典管理", businessType = BusinessType.INSERT)
    @RequestMapping("add")
    @ApiOperation(value="添加", notes="添加字典信息")
    public CommonResult add(@RequestBody @Validated({Create.class}) SysDictType entity){
        int result = service.insertSelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取字典信息")
    public CommonResult<SysDictType> get(Long id) {
        SysDictType entity = service.selectByPrimaryKey(id);
        return CommonResult.success(entity);
    }

    @MyLog(title = "字典管理", businessType = BusinessType.UPDATE)
    @RequestMapping("update")
    @ApiOperation(value="修改信息", notes="修改字典信息")
    public CommonResult update(@RequestBody @Validated({Update.class}) SysDictType entity){
        int result  = service.updateByPrimaryKeySelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysDictType> getList(@RequestBody RequestDTO<SysDictType> params) {
        return service.getPage(params);
    }

    @MyLog(title = "字典管理", businessType = BusinessType.DELETE)
    @RequestMapping("delete")
    @ApiOperation(value="删除",notes="删除")
    public CommonResult delete(Long id){
        int success = service.deleteByPrimaryKey(id);
        return CommonResult.success(success);
    }

}
