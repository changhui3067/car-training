package com.car.training.dao;

import com.car.training.bean.Trainer;

import java.util.List;

/**
 * Created by bill on 11/10/16.
 */
public interface TrainerDAO {
    List<Trainer> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword);
}
