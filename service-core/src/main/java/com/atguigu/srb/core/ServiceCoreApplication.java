package com.atguigu.srb.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：FYQ
 * @description： SpringBoot启动类
 * @date ：2022/7/10 16:50
 */

@SpringBootApplication
@ComponentScan({"com.atguigu.srb", "com.atguigu.common"})
public class ServiceCoreApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ServiceCoreApplication.class, args);
        }catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
