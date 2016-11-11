package com.car.training.dao;

import com.car.training.bean.Autobot;

import java.util.List;

/**
 * Created by bill on 11/11/16.
 */
public interface AutobotDAO {
    List<Autobot> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword);
}


