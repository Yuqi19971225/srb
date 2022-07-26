package com.atguigu.srb.core.controller.admin;

import com.atguigu.common.exception.BusinessException;
import com.atguigu.common.result.R;
import com.atguigu.common.result.ResponseEnum;
import com.atguigu.srb.core.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：FYQ
 * @description：数据字典管理
 * @date ：2022/7/26 21:50
 */
@Slf4j
@RestController
@Api(tags = "数据字典管理")
@RequestMapping("/admin/core/dict")
@CrossOrigin
public class AdminDictController {
    @Resource
    private DictService dictService;

    /**
     * @param file: excel文件
     * @return R 响应结果
     * @description Excel批量导入数据字典
     * @date
     */
    @ApiOperation("Excel批量导入数据字典")
    @PostMapping("/import")
    public R batchImport(
            @ApiParam(value = "Excel文件", required = true)
            @RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            dictService.importData(inputStream);
            return R.ok().message("批量导入成功！");
        } catch (IOException e) {
            //UPLOAD_ERROR(-103, "文件上传错误")
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }
}
