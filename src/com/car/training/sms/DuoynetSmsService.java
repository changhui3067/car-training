package com.car.training.sms;

import org.ironrhino.core.util.ErrorMessage;
import org.ironrhino.core.util.HttpClientUtils;
import org.ironrhino.core.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

@Primary
@Component
public class DuoynetSmsService implements SmsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${sms.duoynet.apiBaseUrl:http://106008.com/WebAPI/SmsAPI.asmx}")
    private String apiBaseUrl;

    @Value("${sms.duoynet.username:shengke}")
    private String username;

    @Value("${sms.duoynet.password:345147}")
    private String password;

    @Value("${sms.duoynet.channel:0}")
    private String channel;

    @Override
    public void send(String phone, String message) throws IOException {
        StringBuilder sbf = new StringBuilder(apiBaseUrl);
        sbf.append("/SendSmsExt?user=").append(username).append("&pwd=").append(password).append("&chid=")
                .append(channel).append("&mobiles=").append(phone).append("&contents=")
                .append(URLEncoder.encode(message, "UTF-8")).append("&sendtime=").append("");
        logger.info("sending '{}' to '{}'", message, phone);
        String callback = HttpClientUtils.get(sbf.toString());
        logger.info("return '{}'", callback);

//        Map<String, String> map = RequestUtils.parseParametersFromQueryString(callback);
//        String result = map.get("APIResult");
//        if (!"0".equals(result))
//            throw new ErrorMessage(result + " : " + map.get("message"));
    }

}
