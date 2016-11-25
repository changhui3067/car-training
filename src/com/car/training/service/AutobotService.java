package com.car.training.service;

import com.car.training.bean.Autobot;
import com.car.training.bean.LoginUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by bill on 11/3/16.
 */
public interface AutobotService {

    Autobot findById(int id);

    Autobot findByUId(int uid);

    Autobot findByLoginUser(LoginUser loginUser);

    List<Autobot> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword);

    void save(Autobot autobot);
}
