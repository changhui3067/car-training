package com.car.training.service.impl;

import com.car.training.bean.Autobot;
import com.car.training.bean.LoginUser;
import com.car.training.dao.AutobotDAO;
import com.car.training.dao.BaseDAO;
import com.car.training.service.AutobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bill on 11/4/16.
 */
@Service
public class AutobotServiceImpl implements AutobotService {

    @Autowired
    BaseDAO baseDAO;

    @Autowired
    AutobotDAO autobotDAO;

    @Override
    public Autobot findById(int id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        return (Autobot) baseDAO.findOne(Autobot.class,map);
    }

    @Override
    public Autobot findByUId(int uid) {
        HashMap<String,Object> map = new HashMap<>();
        LoginUser loginUser = new LoginUser();
        loginUser.setId(uid);
        map.put("loginUser",loginUser);
        return (Autobot) baseDAO.findOne(Autobot.class,map);
    }

    @Override
    public List<Autobot> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        return autobotDAO.search(businessCategory,executionCategory,-1,Integer.MAX_VALUE,keyword);
    }
}