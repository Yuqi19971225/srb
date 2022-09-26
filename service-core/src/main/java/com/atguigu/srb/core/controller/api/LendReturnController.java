package com.atguigu.srb.core.controller.api;


import com.atguigu.common.result.R;
import com.atguigu.srb.core.pojo.entity.LendReturn;
import com.atguigu.srb.core.service.LendReturnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.formatter.qual.ReturnsFormat;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 还款记录表 前端控制器
 * </p>
 *
 * @author FYQ
 * @since 2022-07-10
 */
@Api(tags = "还款计划")
@Slf4j
@RestController
@RequestMapping("/api/core/lendReturn")
public class LendReturnController {

    @Resource
    private LendReturnService lendReturnService;

    @ApiOperation("还款计划")
    @GetMapping("/list/{lendId}")
    public R list(
            @ApiParam(value = "标的id", required = true)
            @PathVariable Long lengId
    ) {
        List<LendReturn> list = lendReturnService.selectByLendId(lengId);
        return R.ok().data("list", list);
    }
}

