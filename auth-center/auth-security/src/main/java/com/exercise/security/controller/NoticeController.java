package com.exercise.security.controller;


import com.exercise.security.service.NoticeService;
import com.exercise.common.core.annotation.MyLog;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.enums.BusinessType;
import com.exercise.common.core.validator.Create;
import com.exercise.common.core.validator.Update;
import com.exercise.security.model.SysNotice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notice/", method = RequestMethod.POST)
@Api(tags = {"公告管理中心 - 公告管理"})
public class NoticeController {

    @Autowired
    private NoticeService service;

    @MyLog(title = "公告管理", businessType = BusinessType.INSERT)
    @RequestMapping("add")
    @ApiOperation(value="添加", notes="添加公告信息")
    public CommonResult add(@RequestBody @Validated({Create.class}) SysNotice entity){
        int result = service.insertSelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取公告信息")
    public CommonResult<SysNotice> get(Long id) {
        SysNotice entity = service.selectByPrimaryKey(id);
        return CommonResult.success(entity);
    }

    @MyLog(title = "公告管理", businessType = BusinessType.UPDATE)
    @RequestMapping("update")
    @ApiOperation(value="修改信息", notes="修改公告信息")
    public CommonResult update(@RequestBody @Validated({Update.class}) SysNotice entity){
        int result  = service.updateByPrimaryKeySelective(entity);
        return CommonResult.success(result);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysNotice> getList(@RequestBody RequestDTO<SysNotice> params) {
        return service.getPage(params);
    }

    @MyLog(title = "公告管理", businessType = BusinessType.DELETE)
    @RequestMapping("delete")
    @ApiOperation(value="删除",notes="删除")
    public CommonResult delete(Long id){
        int success = service.deleteByPrimaryKey(id);
        return CommonResult.success(success);
    }

}
