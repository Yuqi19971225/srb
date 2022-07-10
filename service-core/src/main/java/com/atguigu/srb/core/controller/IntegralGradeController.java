package com.atguigu.srb.core.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author FYQ
 * @since 2022-07-10
 */
@Api(tags = "积分等级系统")
@RestController
@RequestMapping("/web/core/integralGrade")
public class IntegralGradeController {

    @GetMapping("/test")
    @ApiOperation("test")
    public void test(){

    }
}

