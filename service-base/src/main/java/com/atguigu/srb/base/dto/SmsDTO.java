package com.atguigu.srb.base.dto;

/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/10/3 21:24
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "短信")
public class SmsDTO {

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "消息内容")
    private String message;
}