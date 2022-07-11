package com.atguigu.common.exception;

import com.atguigu.common.result.ResponseEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：FYQ
 * @description： 自定义异常类
 * @date ：2022/7/11 13:45
 */
@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    //状态码
    private Integer code;

    //错误信息
    private String message;

    /**
     * @param message:错误信息
     * @return null
     * @description
     * @date
     */
    public BusinessException(String message) {
        this.message = message;
    }

    /**
     * @param message: 错误信息
     * @param code:    状态码
     * @return null
     * @description TODO
     * @date
     */
    public BusinessException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    /**
     * @param message: 错误信息
     * @param code:    错误码
     * @param cause:   原始异常对象
     * @return null
     * @description TODO
     * @date
     */
    public BusinessException(String message, Integer code, Throwable cause) {
        super(cause);
        this.message = message;
        this.code = code;
    }

    /**
     * @param responseEnum:枚举类型
     * @return null
     * @description 接受枚举类型
     * @date
     */
    public BusinessException(ResponseEnum responseEnum) {
        this.message = responseEnum.getMessage();
        this.code = responseEnum.getCode();
    }

    /**
     * @param responseEnum:接受枚举类型
     * @param cause:原始异常对象
     * @return null
     * @description TODO
     * @date
     */
    public BusinessException(ResponseEnum responseEnum, Throwable cause) {
        super(cause);
        this.message = responseEnum.getMessage();
        this.code = responseEnum.getCode();
    }
}
