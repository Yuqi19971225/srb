package com.atguigu.srb.core.service;

import com.atguigu.srb.core.pojo.entity.UserInfo;
import com.atguigu.srb.core.pojo.query.UserInfoQuery;
import com.atguigu.srb.core.pojo.vo.LoginVO;
import com.atguigu.srb.core.pojo.vo.RegisterVO;
import com.atguigu.srb.core.pojo.vo.UserInfoVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author FYQ
 * @since 2022-07-10
 */
public interface UserInfoService extends IService<UserInfo> {

    void register(RegisterVO registerVo);

    UserInfoVO login(LoginVO loginVO, String ip);

    Page<UserInfo> listByPage(Page<UserInfo> userInfoPage, UserInfoQuery userInfoQuery);
}
