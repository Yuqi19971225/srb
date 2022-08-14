package com.atguigu.srb.sms.service.Impl;

import com.atguigu.common.exception.BusinessException;
import com.atguigu.common.result.ResponseEnum;
import com.atguigu.srb.sms.service.SmsService;
import com.atguigu.srb.sms.util.SmsProperties;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ：FYQ
 * @description：TODO
 * @date ：2022/8/14 16:21
 */
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public void send(String mobile, String templateId, String code) {

        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential(SmsProperties.SECRET_ID, SmsProperties.SERRET_KEY);
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            SmsClient client = new SmsClient(cred, "ap-nanjing", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {mobile};
            req.setPhoneNumberSet(phoneNumberSet1);

            req.setSmsSdkAppId(SmsProperties.SMS_SDK_APP_ID);
            req.setSignName(SmsProperties.SIGN_NAME);
            req.setTemplateId(templateId);

            String[] templateParamSet1 = {code};
            req.setTemplateParamSet(templateParamSet1);

            // 返回的resp是一个SendSmsResponse的实例，与请求对象对应
            SendSmsResponse resp = client.SendSms(req);
            // 输出json格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(resp));


        } catch (TencentCloudSDKException e) {
            log.error("腾讯云短信发送SDK调用失败：");
            log.error("ErrorCode=" + e.getErrorCode());
            log.error("ErrorMessage=" + e.getMessage());
            throw new BusinessException(ResponseEnum.TENCENT_SMS_ERROR, e);
        }
    }
}
