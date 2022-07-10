package com.atguigu.srb.core.controller.admin;


import com.atguigu.common.result.R;
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
 * 积分等级表 管理员控制器
 * </p>
 *
 * @author FYQ
 * @since 2022-07-10
 */
@Api(tags = "积分等级管理")
@CrossOrigin
@RestController
@RequestMapping("admin/core/integralGrade")
public class AdminIntegralGradeController {
    @Resource
    private IntegralGradeService integralGradeService;

    /**
     * @param :
     * @return R
     * @description 展示所有积分等级列表
     * @date
     */
    @ApiOperation(value = "积分等级列表")
    @GetMapping("/list")
    public R listAll() {
        List<IntegralGrade> integralGradeList = integralGradeService.list();
        return R.ok().data(integralGradeList);
    }

    /**
     * @param id:
     * @return R
     * @description 根据id删除积分等级
     * @date
     */
    @ApiOperation(value = "根据id删除积分等级", notes = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public R removeById(
            @PathVariable
            @ApiParam(value = "数据id", required = true, example = "100")
                    Long id) {
        boolean result = integralGradeService.removeById(id);
        if (result) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }
    }
}

