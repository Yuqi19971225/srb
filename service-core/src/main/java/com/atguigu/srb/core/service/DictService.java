package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author FYQ
 * @since 2022-07-10
 */
public interface DictService extends IService<Dict> {
    void importData(InputStream inputStream);

}
