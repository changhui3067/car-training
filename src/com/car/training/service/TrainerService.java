package com.car.training.service;

import com.car.training.bean.LoginUser;
import com.car.training.bean.Trainer;

import java.util.List;

/**
 * Created by bill on 11/7/16.
 */
public interface TrainerService {
    Trainer findById(int id);

    Trainer findByLoginUser(LoginUser loginUser);

    List<Trainer> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword);

}
