package com.car.training.service;

import com.car.training.bean.Autobot;
import com.car.training.bean.LoginUser;

import java.util.List;

/**
 * Created by bill on 11/3/16.
 */
public interface AutobotService {

    Autobot findById(int id);

    Autobot findByUId(int uid);

    Autobot findByLoginUser(LoginUser loginUser);

    List<Autobot> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword);

    void save(Autobot autobot);
}
