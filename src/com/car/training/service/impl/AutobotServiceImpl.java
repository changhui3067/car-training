package com.car.training.service.impl;

import com.car.training.bean.Autobot;
import com.car.training.bean.LoginUser;
import com.car.training.dao.AutobotDAO;
import com.car.training.dao.BaseDAO;
import com.car.training.service.AutobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
    @Transactional
    public Autobot findById(int id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        return (Autobot) baseDAO.findOne(Autobot.class,map);
    }

    @Override
    @Transactional
    public Autobot findByUId(int uid) {
        HashMap<String,Object> map = new HashMap<>();
        LoginUser loginUser = new LoginUser();
        loginUser.setId(uid);
        map.put("loginUser",loginUser);
        return (Autobot) baseDAO.findOne(Autobot.class,map);
    }

    @Override
    @Transactional
    public Autobot findByLoginUser(LoginUser loginUser) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("loginUser",loginUser);
        return (Autobot) baseDAO.findOne(Autobot.class,map);
    }

    @Override
    @Transactional
    public List<Autobot> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        return autobotDAO.search(businessCategory,executionCategory,minAutoYears,maxAutoYears,keyword,1);
    }

    @Override
    @Transactional
    public List<Autobot> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword, int pageNo) {
        return autobotDAO.search(businessCategory,executionCategory,minAutoYears,maxAutoYears,keyword,pageNo);
    }

    @Override
    @Transactional
    public int rowCount(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        return autobotDAO.rowCount(businessCategory,executionCategory,minAutoYears,maxAutoYears,keyword);
    }

    @Override
    @Transactional
    public void save(Autobot autobot){
        baseDAO.save(autobot);
    }
}
