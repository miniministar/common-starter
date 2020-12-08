package com.exercise.security.controller;


import com.exercise.common.core.annotation.MyLog;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.enums.BusinessType;
import com.exercise.common.core.validator.Create;
import com.exercise.common.core.validator.Update;
import com.exercise.security.model.SysDictData;
import com.exercise.security.service.DictDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dict/data", method = RequestMethod.POST)
@Api(tags = {"系统管理中心 - 字典数据管理"})
public class DictDataController {

    @Autowired
    private DictDataService service;

    @MyLog(title = "字典数据管理", businessType = BusinessType.INSERT)
    @RequestMapping("add")
    @ApiOperation(value="添加", notes="添加字典数据信息")
    public CommonResult add(@RequestBody @Validated({Create.class}) SysDictData entity){
        int result = service.insertSelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取字典数据信息")
    public CommonResult<SysDictData> get(Long id) {
        SysDictData entity = service.selectByPrimaryKey(id);
        return CommonResult.success(entity);
    }

    @MyLog(title = "字典数据管理", businessType = BusinessType.UPDATE)
    @RequestMapping("update")
    @ApiOperation(value="修改信息", notes="修改字典数据信息")
    public CommonResult update(@RequestBody @Validated({Update.class}) SysDictData entity){
        int result  = service.updateByPrimaryKeySelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysDictData> getList(@RequestBody RequestDTO<SysDictData> params) {
        return service.getPage(params);
    }

    @MyLog(title = "字典数据管理", businessType = BusinessType.DELETE)
    @RequestMapping("delete")
    @ApiOperation(value="删除",notes="删除")
    public CommonResult delete(Long id){
        int success = service.deleteByPrimaryKey(id);
        return CommonResult.success(success);
    }

}
