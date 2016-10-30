package com.car.training.utils;

import org.ironrhino.core.fs.FileStorage;
import org.ironrhino.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bill on 10/25/16.
 */
@Component("fileUploaderUtil")
public class FileUploaderUtil {
    @Autowired
    public FileStorage fileStorage;

    /**
     * 单个上传base64公用接口
     */
    public String uploadFile(String prePath, String imgData) {
        if (imgData == null) {
            throw RestStatus.valueOf(RestStatus.CODE_FIELD_INVALID, "参数有误");
        }

        String returnUrl = "";
        String imgPath;
        // 使用BASE64对图片文件数据进行解码操作
        try {
            // 通过Base64解密，将图片数据解密成字节数组
            byte[] bytes = Base64.getDecoder().decode(imgData.split(",")[1]);
            for (int j = 0; j < bytes.length; ++j) {
                if (bytes[j] < 0) {// 调整异常数据
                    bytes[j] += 256;
                }
            }
            Pattern p = Pattern.compile("(?<=data:image/)\\w+(?=;)");
            Matcher m = p.matcher(imgData);
            if (m.find()) {
                imgPath = String.valueOf(System.currentTimeMillis() + "." + m.group(0));
                InputStream in = new ByteArrayInputStream(bytes);
                fileStorage.write(in, prePath.concat(imgPath));
                returnUrl = fileStorage.getFileUrl(prePath.concat(imgPath));
            } else {
                throw RestStatus.valueOf(RestStatus.CODE_FIELD_INVALID, "参数有误");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnUrl;

    }


}
