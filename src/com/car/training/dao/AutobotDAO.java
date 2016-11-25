package com.car.training.dao;

import com.car.training.bean.Autobot;

import java.util.List;
import java.util.Set;

/**
 * Created by bill on 11/11/16.
 */
public interface AutobotDAO {
    List<Autobot> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword);

    List<Autobot> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword, int pageNo);

    int rowCount(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword, int pageNo);
}


