package com.atguigu.srb.core.controller.admin;


import com.atguigu.srb.core.pojo.entity.IntegralGrade;
import com.atguigu.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 积分等级表 管理员制器
 * </p>
 *
 * @author FYQ
 * @since 2022-07-10
 */
@Api("积分等级管理")
@CrossOrigin
@RestController
@RequestMapping("admin/core/integralGrade")
public class AdminIntegralGradeController {
    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation(value = "积分等级列表")
    @GetMapping("/list")
    public List<IntegralGrade> listAll() {
        return integralGradeService.list();
    }

    @ApiOperation(value = "根据id删除积分等级", notes = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public boolean removeById(
            @PathVariable
            @ApiParam(value = "数据id", required = true, example = "100")
                    Long id) {
        return integralGradeService.removeById(id);
    }
}

