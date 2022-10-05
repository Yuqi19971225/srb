package com.atguigu.srb.sms.receiver;

import com.atguigu.srb.base.dto.SmsDTO;
import com.atguigu.srb.rabbitutil.constant.MQConst;
import com.atguigu.srb.sms.service.SmsService;
import com.atguigu.srb.sms.util.SmsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.IOException;


/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/10/5 21:06
 */
@Slf4j
@Component
public class SmsReceiver {
    @Resource
    private SmsService service;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConst.QUEUE_SMS_ITEM, durable = "true"),
            exchange = @Exchange(value = MQConst.EXCHANGE_TOPIC_SMS),
            key = {MQConst.ROUTING_SMS_ITEM}
    ))
    public void send(SmsDTO smsDTO) throws IOException {
        log.info("Sms receiver 消息监听");
        String code = smsDTO.getMessage();
        service.send(smsDTO.getMobile(), SmsProperties.TEMPLATE_ID, code);
    }
}
