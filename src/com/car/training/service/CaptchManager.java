package com.car.training.service;

import java.awt.image.BufferedImage;

public interface CaptchManager {

    public BufferedImage refreshCode(String sid);

    public boolean volidateCode(String sid, String code);

    public void clear();
}
