package com.atguigu.srb.sms.util;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/8/14 9:34
 */
@Data
@Component
@ConfigurationProperties(prefix = "tencent.sms")
public class SmsProperties implements InitializingBean {

//    #腾讯云短信
//    tencent:
//    sms:
//    secretId: AKIDfAydBUYOzL7mCMGuJTO3XpvmOltmQoxt
//    secretKey: oNhmbIsHSO5ZrzvfEaljTzHJ7h8KH1Xo
//    smsSdkAppId: 1400721392
//    templateId: 1508428
//    signName: 猪猪的技术日记公众号

    private String secretId;
    private String secretKey;
    private String smsSdkAppId;
    private String templateId;
    private String signName;

    public static String SECRET_ID;
    public static String SERRET_KEY;
    public static String SMS_SDK_APP_ID;
    public static String TEMPLATE_ID;
    public static String SIGN_NAME;

    //当私有成员被赋值后，此方法自动被调用，从而初始化常量
    @Override
    public void afterPropertiesSet() throws Exception {
        SECRET_ID = secretId;
        SERRET_KEY = secretKey;
        SMS_SDK_APP_ID = smsSdkAppId;
        TEMPLATE_ID = templateId;
        SIGN_NAME = signName;
    }
}
