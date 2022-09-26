package com.atguigu.srb.core.service.impl;

import com.atguigu.srb.core.pojo.entity.LendReturn;
import com.atguigu.srb.core.mapper.LendReturnMapper;
import com.atguigu.srb.core.service.LendReturnService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 还款记录表 服务实现类
 * </p>
 *
 * @author FYQ
 * @since 2022-07-10
 */
@Service
public class LendReturnServiceImpl extends ServiceImpl<LendReturnMapper, LendReturn> implements LendReturnService {

    @Override
    public List<LendReturn> selectByLendId(Long lendId) {
        QueryWrapper<LendReturn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lend_id", lendId);
        List<LendReturn> list = baseMapper.selectList(queryWrapper);
        return list;
    }
}
