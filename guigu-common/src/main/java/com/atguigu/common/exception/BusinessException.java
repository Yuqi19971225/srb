package com.atguigu.common.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：FYQ
 * @description： 自定义异常类
 * @date ：2022/7/11 13:45
 */
@Data
@NoArgsConstructor
public class BusinessExceptionHandler {
    //状态码
    private Integer code;
    //错误信息
    private String message;

}
