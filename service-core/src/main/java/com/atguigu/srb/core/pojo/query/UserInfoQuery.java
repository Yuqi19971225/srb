package com.atguigu.srb.core.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/8/28 16:36
 */
@Data
@ApiModel(value = "会员搜索对象")
public class UserInfoQuery {

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "用户状态")
    private Integer Status;

    @ApiModelProperty(value = "用户类型 1：出借人 2：借款人")
    private Integer userType;
}
