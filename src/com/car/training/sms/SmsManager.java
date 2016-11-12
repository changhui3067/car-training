package com.car.training.sms;

import org.apache.commons.lang3.StringUtils;
import org.ironrhino.common.support.SettingControl;
import org.ironrhino.core.cache.CacheManager;
import org.ironrhino.core.util.CodecUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class SmsManager {

    private static final String CACHE_NAMESPACE_SMSCODE = "SMSCODE";

    private static final Integer CACHE_SMSCODE_EXPIRED_MINUTES = 15;

    @Autowired
    private SmsService defaultSmsService;

    @Autowired
    private Map<String, SmsService> smsServices;

    @Autowired
    private SettingControl settingControl;

    @Autowired
    private CacheManager cacheManager;

    public SmsService findSmsService() {
        SmsService smsService = null;
        String provider = settingControl.getStringValue("smsService.provider");
        if (StringUtils.isNotBlank(provider)) {
            provider = StringUtils.uncapitalize(provider);
            smsService = smsServices.get(provider + "SmsService");
            if (smsService == null)
                smsService = smsServices.get(provider);
        }
        if (smsService == null)
            smsService = defaultSmsService;
        return smsService;
    }

    public void send(String phone, SmsTemplate smsTemplate) throws IOException {
        String random = this.generateCode(phone);
        String template = smsTemplate.getDisplayName();
        if (StringUtils.isBlank(template))
            template = smsTemplate.toString();
        String message = String.format(template, random, CACHE_SMSCODE_EXPIRED_MINUTES);
        if ("alidayu".equals(settingControl.getStringValue("smsService.provider"))) {
            message = smsTemplate.getName(); // 特殊处理阿里大鱼短信通道把模板名丢给实现类处理
        }
        findSmsService().send(phone, message);
        cacheManager.put(phone, random, CACHE_SMSCODE_EXPIRED_MINUTES, TimeUnit.MINUTES, CACHE_NAMESPACE_SMSCODE);
    }

    public void send(String phone, SmsTemplate smsTemplate, String code) throws IOException {
        String template = smsTemplate.getDisplayName();
        if (StringUtils.isBlank(template))
            template = smsTemplate.toString();
        String message = String.format(template, code);
        if ("alidayu".equals(settingControl.getStringValue("smsService.provider"))) {
            message = smsTemplate.getName() + "_" + code; // 特殊处理阿里大鱼短信通道把模板名+code丢给实现类处理
        }
        findSmsService().send(phone, message);
    }

    private String generateCode(String phone) {
        String random = CodecUtils.randomDigitalString(6);
        return random;
    }

    public boolean checkCode(String phone, String inputCode) {
        if(inputCode !=null){
            return inputCode.equals(cacheManager.get(phone, CACHE_NAMESPACE_SMSCODE));
        }
        return false;
    }

}
