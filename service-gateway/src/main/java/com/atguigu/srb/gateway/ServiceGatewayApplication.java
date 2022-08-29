package com.atguigu.srb.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/8/29 21:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceGatewayApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ServiceGatewayApplication.class, args);
        }catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
