package com.exercise.controller;

import com.exercise.common.core.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@RestController
@RequestMapping(value = "/r")
@Slf4j
public class OrderController {

    @GetMapping(value = "/r1")
    @PreAuthorize("hasAnyAuthority('p1')") // 拥有p1权限方可发个文
    public CommonResult r1(HttpServletRequest request)
    {
        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("params:{}", parameterMap);
        Enumeration<String> headerNames = request.getHeaderNames();
        log.info("headers:{}, {}, {}", headerNames, request.getHeader("user"), request.getHeader("Authorization"));
        return CommonResult.success("访问资源1");
    }

    @GetMapping(value = "/r2")
    @PreAuthorize("hasAnyAuthority('p2')") // 拥有p2权限方可发个文
    public CommonResult r2()
    {
        return CommonResult.success("访问资源2");
    }

    @GetMapping(value = "/r3")
    public CommonResult r3(@RequestParam Map<String, Object> params)
    {
        log.info("{}", params);
        return CommonResult.success("访问资源3");
    }

    @PostMapping(value = "/r4")
    public CommonResult r4(@RequestBody Map<String, Object> params)
    {
        log.info("{}", params);
        return CommonResult.success("访问资源4");
    }
}
