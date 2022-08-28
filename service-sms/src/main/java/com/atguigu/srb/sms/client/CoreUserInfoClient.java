package com.atguigu.srb.sms.client;

import com.atguigu.srb.sms.client.fallback.CoreUserInfoClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/8/28 21:00
 */
@FeignClient(value = "service-core",fallback = CoreUserInfoClientFallback.class)
public interface CoreUserInfoClient {

    @GetMapping("api/core/userInfo/checkMobile/{mobile}")
    Boolean checkMobile(@PathVariable String mobile);
}
