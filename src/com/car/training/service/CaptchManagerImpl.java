package com.car.training.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class CaptchManagerImpl implements CaptchManager {

    private static Map<String, String> cm = new HashMap<>();
    private Font mFont = new Font("", Font.ROMAN_BASELINE, 18);

    @Override
    public BufferedImage refreshCode(String sid) {
        String c = genCode(null);
        cm.put(sid, c);
        return genImage(c);
    }

    @Override
    public boolean volidateCode(String sid, String code) {

        if (!StringUtils.isBlank(code)) {
            if (code.equals(cm.get(sid))) {
                cm.remove(sid);
                return true;
            }
        }

        return false;
    }

    private String genCode(String charSet) {

        String s = StringUtils.isBlank(charSet) ? "1234567890" : charSet;

        String code = "";

        Random ran = new Random();

        for (int i = 0; i < 4; i++) {
            code += s.charAt(ran.nextInt(10));
        }

        return code;
    }

    private BufferedImage genImage(String code) {

        int width = 100, height = 18;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(1, 1, width - 1, height - 1);
        g.setColor(new Color(102, 102, 102));
        g.drawRect(0, 0, width - 1, height - 1);
        g.setFont(mFont);

        g.setColor(getRandColor(160, 200));

        // 画随机线
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g.drawLine(x, y, x + xl, y + yl);
        }

        // 从另一方向画随机线
        for (int i = 0; i < 70; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(12) + 1;
            int yl = random.nextInt(6) + 1;
            g.drawLine(x, y, x - xl, y - yl);
        }

        for (int j = 0; j < code.length(); j++) {
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(String.valueOf(code.charAt(j)), 15 * j + 10, 16);
        }
        g.dispose();

        return image;
    }

    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void clear() {
        cm.clear();
    }

}
