package com.exercise.security.controller;


import com.exercise.security.service.LoginLogService;
import com.exercise.common.core.annotation.MyLog;
import com.exercise.common.core.api.CommonResult;
import com.exercise.common.core.api.datatable.RequestDTO;
import com.exercise.common.core.api.datatable.ResultDTO;
import com.exercise.common.core.enums.BusinessType;
import com.exercise.common.core.util.excel.ExcelUtil;
import com.exercise.security.model.SysLoginLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/log/login/", method = RequestMethod.POST)
@Api(tags = {"日志管理中心 - 系统日志管理"})
public class LoginLogController {

    @Autowired
    private LoginLogService service;

    @RequestMapping("get")
    @ApiOperation(value="获取信息",notes="获取系统日志信息")
    public CommonResult<SysLoginLog> get(Long id) {
        SysLoginLog entity = service.selectByPrimaryKey(id);
        return CommonResult.success(entity);
    }

    @RequestMapping("list")
    @ApiOperation(value="分页搜索",notes="查询参数Filter")
    public ResultDTO<SysLoginLog> getList(@RequestBody RequestDTO<SysLoginLog> params) {
        return service.getPage(params);
    }

    @MyLog(title = "系统日志管理", businessType = BusinessType.EXPORT)
    @RequestMapping("export")
    @ApiOperation(value="导出",notes="查询参数Filter")
    public CommonResult export(@RequestBody RequestDTO<SysLoginLog> params) {
        List<SysLoginLog> list = service.getList(params.getFilter());
        ExcelUtil<SysLoginLog> excelUtil = new ExcelUtil<>(SysLoginLog.class);
        return excelUtil.exportExcel(list, "系统日志");
    }

}
