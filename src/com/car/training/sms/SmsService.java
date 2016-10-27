package com.car.training.sms;

import java.io.IOException;

public interface SmsService {

    /**
     * 发送手机短信
     */
    void send(String phone, String message) throws IOException;

}