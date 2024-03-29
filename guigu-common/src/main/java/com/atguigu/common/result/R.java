package com.atguigu.common.result;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：FYQ
 * @description： 统一返回结果
 * @date ：2022/7/10 21:10
 */

@Data
public class R<T> {
    //响应状态码
    private Integer code;
    //响应信息
    private String message;
    //数据
    private Map<String, Object> data = new HashMap<>();

    /**
     * @param :
     * @return null
     * @description 构造器私有
     * @date
     */
    private R() {
    }

    /**
     * @param :
     * @return R
     * @description 返回成功
     * @date
     */
    public static R ok() {
        R r = new R();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }

    /**
     * @param :
     * @return R
     * @description 返回失败
     * @date
     */
    public static R error() {
        R r = new R();
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(ResponseEnum.ERROR.getMessage());
        return r;
    }

    /**
     * @param responseEnum:
     * @return R
     * @description 设置特定结果
     * @date
     */
    public static R setResult(ResponseEnum responseEnum) {
        R r = new R();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;
    }

    /**
     * @param message:
     * @return R
     * @description 设置响应信息
     * @date
     */
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * @param code:
     * @return R
     * @description 设置响应状态码
     * @date
     */
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    /**
     * @param key:
     * @param value:
     * @return R
     * @description TODO
     * @date
     */
    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    /**
     * @param map:
     * @return R
     * @description 设置信息
     * @date
     */
    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }


}
