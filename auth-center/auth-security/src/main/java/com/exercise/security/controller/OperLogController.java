package com.exercise.security.controller;


import com.exercise.security.service.OperLogService;
import com.exercise.common.core.annotation.MyLog;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.enums.BusinessType;
import com.exercise.common.core.util.excel.ExcelUtil;
import com.exercise.security.model.SysOperLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/log/operate/", method = RequestMethod.POST)
@Api(tags = {"日志管理中心 - 操作日志管理"})
public class OperLogController {

    @Autowired
    private OperLogService service;

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取操作日志信息")
    public CommonResult<SysOperLog> get(Long id) {
        SysOperLog entity = service.selectByPrimaryKey(id);
        return CommonResult.success(entity);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysOperLog> getList(@RequestBody RequestDTO<SysOperLog> params) {
        return service.getPage(params);
    }


    @MyLog(title = "操作日志管理", businessType = BusinessType.EXPORT)
    @RequestMapping("export")
    @ApiOperation(value="导出",notes="查询参数Filter")
    public CommonResult export(@RequestBody RequestDTO<SysOperLog> params) {
        List<SysOperLog> list = service.getList(params.getFilter());
        ExcelUtil<SysOperLog> excelUtil = new ExcelUtil<>(SysOperLog.class);
        return excelUtil.exportExcel(list, "操作日志");
    }
}
