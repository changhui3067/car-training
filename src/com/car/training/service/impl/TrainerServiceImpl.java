package com.car.training.service.impl;

import com.car.training.bean.LoginUser;
import com.car.training.bean.Trainer;
import com.car.training.dao.BaseDAO;
import com.car.training.dao.TrainerDAO;
import com.car.training.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bill on 11/6/16.
 */
@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    BaseDAO baseDAO;

    @Autowired
    TrainerDAO trainerDAO;


    @Override
    @Transactional
    public Trainer findById(int id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        return (Trainer) baseDAO.findOne(Trainer.class,map);
    }

    @Override
    @Transactional
    public Trainer findByUId(int uid) {
        HashMap<String,Object> map = new HashMap<>();
        LoginUser loginUser = new LoginUser();
        loginUser.setId(uid);
        map.put("loginUser",loginUser);
        return (Trainer) baseDAO.findOne(Trainer.class,map);
    }

    @Override
    @Transactional
    public  Trainer findByLoginUser(LoginUser loginUser) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("loginUser",loginUser);
        return (Trainer) baseDAO.findOne(Trainer.class, map);
    }

    @Override
    public List<Trainer> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        return trainerDAO.search(businessCategory,executionCategory,-1,Integer.MAX_VALUE,keyword);
    }
}
