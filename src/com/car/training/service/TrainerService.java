package com.car.training.service;

import com.car.training.bean.LoginUser;
import com.car.training.bean.Trainer;

import java.util.List;
import java.util.Set;

/**
 * Created by bill on 11/7/16.
 */
public interface TrainerService {
    Trainer findById(int id);

    Trainer findByUId(int uid);

    Trainer findByLoginUser(LoginUser loginUser);

    List<Trainer> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword);

    List<Trainer> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword, int pageNo);

    int rowCount(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword);
}
