package com.atguigu.srb.core.controller.api;


import com.alibaba.fastjson.JSON;
import com.atguigu.common.result.R;
import com.atguigu.srb.base.util.JwtUtils;
import com.atguigu.srb.core.hfb.RequestHelper;
import com.atguigu.srb.core.pojo.vo.UserBindVO;
import com.atguigu.srb.core.service.UserBindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 用户绑定表 前端控制器
 * </p>
 *
 * @author FYQ
 * @since 2022-07-10
 */
@Slf4j
@Api(tags = "会员账户绑定")
@RestController
@RequestMapping("/api/core/userBind")
public class UserBindController {

    @Autowired
    private UserBindService userBindService;

    @ApiOperation("用户绑定")
    @PostMapping("/auth/bind")
    public R bind(@RequestBody UserBindVO userBindVO, HttpServletRequest httpServletRequest) {

        String token = httpServletRequest.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        String formStr = userBindService.commitBindUser(userBindVO, userId);
        return R.ok().data("formStr", formStr);
    }


    @ApiOperation("账户绑定异步回调")
    @PostMapping("/notify")
    public String notify(HttpServletRequest request) {
        Map<String, Object> parameterMap = RequestHelper.switchMap(request.getParameterMap());
        log.info("用户账号绑定异步回调：" + JSON.toJSONString(parameterMap));

        //校验签名
        if (!RequestHelper.isSignEquals(parameterMap)) {
            log.info("用户账号绑定异步回调签名错误："+JSON.toJSONString(parameterMap));
            return "fail";
        }

        //修改绑定状态
        userBindService.notify(parameterMap);
        return "success";
    }

}

