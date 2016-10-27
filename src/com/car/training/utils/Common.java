package com.car.training.utils;

import org.ironrhino.core.fs.FileStorage;
import org.ironrhino.core.remoting.Remoting;
import org.ironrhino.rest.RestStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.LinkedHashSet;

@Remoting
public class Common {
    public static String CARTRAINING_UPLOAD_FILEPATH = "/car/training/upload/";
    @Autowired
    public FileStorage fileStorage;
    public Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    /**
     * 批量上传base64公用接口
     */
    public LinkedHashSet<String> uploadFiles(String[] imgPaths, String[] imgs) {
        if (imgPaths == null && imgs.length == 0) {
            throw RestStatus.valueOf(RestStatus.CODE_FIELD_INVALID, "参数有误");
        }

        LinkedHashSet<String> set = new LinkedHashSet<String>();
        logger.info("上传文件青牛图片数量：" + imgs.length);

        // 使用BASE64对图片文件数据进行解码操作
        for (int i = 0; i < imgs.length; i++) {
            if (imgs[i] != null) {
                try {
                    // 通过Base64解密，将图片数据解密成字节数组
                    byte[] bytes = Base64.getDecoder().decode(imgs[i].split(",")[1]);
                    for (int j = 0; j < bytes.length; ++j) {
                        if (bytes[j] < 0) {// 调整异常数据
                            bytes[j] += 256;
                        }
                    }
                    InputStream in = new ByteArrayInputStream(bytes);
                    fileStorage.write(in, CARTRAINING_UPLOAD_FILEPATH.concat(imgPaths[i]));
                    String fileUrl = fileStorage.getFileUrl(CARTRAINING_UPLOAD_FILEPATH.concat(imgPaths[i]));
                    set.add(fileUrl);
                    logger.info("上传文件青牛返回路径：" + fileUrl);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return set;
    }

    /**
     * 单个上传base64公用接口
     */
    public String uploadFile(String imgData) {
        if (imgData == null) {
            throw RestStatus.valueOf(RestStatus.CODE_FIELD_INVALID, "参数有误");
        }

        String returnUrl = "", imgPath = "";
        // 使用BASE64对图片文件数据进行解码操作
        if (imgData != null) {
            try {
                // 通过Base64解密，将图片数据解密成字节数组
                byte[] bytes = Base64.getDecoder().decode(imgData.split(",")[1]);
                for (int j = 0; j < bytes.length; ++j) {
                    if (bytes[j] < 0) {// 调整异常数据
                        bytes[j] += 256;
                    }
                }
                imgPath = String.valueOf(System.currentTimeMillis() + "." + imgData.substring(imgData.indexOf("/") + 1, imgData.indexOf(";")));
                InputStream in = new ByteArrayInputStream(bytes);
                fileStorage.write(in, CARTRAINING_UPLOAD_FILEPATH.concat(imgPath));
                String fileUrl = fileStorage.getFileUrl(CARTRAINING_UPLOAD_FILEPATH.concat(imgPath));
                logger.info("上传文件青牛返回路径：" + fileUrl);
                returnUrl = fileUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnUrl;
    }

    /**
     * 删除图片功能
     **/
    public void removeFile(String fileUrl) {
        fileStorage.delete(fileUrl.substring(fileUrl.lastIndexOf(".com") + 4));
    }
}
