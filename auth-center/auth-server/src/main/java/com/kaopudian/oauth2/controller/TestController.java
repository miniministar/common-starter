package com.exercise.oauth2.controller;


import com.exercise.common.core.api.CommonPage;
import com.exercise.common.core.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/test/", method = RequestMethod.POST)
@Slf4j
@Api(tags = {"api测试 - "})
public class TestController {

    @RequestMapping("/common/success")
    @ApiOperation(value="一般响应 - 成功",notes="")
    public CommonResult commonSuccess() {
        Date time = new Date();
        return CommonResult.success(time);
    }
    @RequestMapping("/common/fail")
    @ApiOperation(value="一般响应 - 失败",notes="")
    public CommonResult commonFail() {
        int i = 1/0;
        return CommonResult.failed("失败");
    }

    @RequestMapping("/page/success")
    @ApiOperation(value="分页响应 - 成功",notes="")
    public CommonPage pageSuccess() {
        Date time = new Date();
        List list = new ArrayList();

        for(int i = 0 ; i < 10 ; i ++ ) {
            Map row = new HashMap();
            row.put("id", (i+1) );
            row.put("time",time);
            list.add(row);
        }
        return CommonPage.restPage(list);
    }
    @RequestMapping("/page/fail")
    @ApiOperation(value="分页响应 - 失败",notes="")
    public CommonPage pageFail() {
        int n = 1/0;
        Date time = new Date();
        List list = new ArrayList();

        for(int i = 0 ; i < 10 ; i ++ ) {
            Map row = new HashMap();
            row.put("id", (i+1) );
            row.put("time",time);
            list.add(row);
        }
        return CommonPage.restPage(list);
    }
}
