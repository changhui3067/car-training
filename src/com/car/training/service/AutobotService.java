package com.car.training.service;

import com.car.training.bean.Autobot;

import java.util.List;

/**
 * Created by bill on 11/3/16.
 */
public interface AutobotService {

    Autobot findById(int id);

    Autobot findByUId(int uid);

    List<Autobot> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword);

    void save(Autobot autobot);
}
