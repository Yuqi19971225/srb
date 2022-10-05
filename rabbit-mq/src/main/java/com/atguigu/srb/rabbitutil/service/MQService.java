package com.atguigu.srb.rabbitutil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/10/3 21:10
 */
@Slf4j
@Service
public class MQService {
    @Resource
    private AmqpTemplate amqpTemplate;

    /**
     * @param exchange:交换机
     * @param routingKey:路由
     * @param message:消息
     * @return Boolean
     * @description 发送消息
     * @date
     */
    public Boolean sendMessage(String exchange, String routingKey, Object message) {
        log.info("发送消息。。。。。。");
        amqpTemplate.convertAndSend(exchange,routingKey,message);
        return true;
    }
}
