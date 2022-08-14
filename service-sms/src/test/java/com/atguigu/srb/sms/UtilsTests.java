package com.atguigu.srb.sms;

import com.atguigu.srb.sms.util.SmsProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/8/14 9:49
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UtilsTests {
    @Test
    public void testProperties() {
        System.out.println(SmsProperties.SECRET_ID);
        System.out.println(SmsProperties.SERRET_KEY);
        System.out.println(SmsProperties.SMS_SDK_APP_ID);
        System.out.println(SmsProperties.TEMPLATE_ID);
        System.out.println(SmsProperties.SIGN_NAME);
    }

}
