package com.car.training.service.impl;

import com.car.training.bean.Autobot;
import com.car.training.bean.LoginUser;
import com.car.training.bean.PersonInfo;
import com.car.training.bean.Trainer;
import com.car.training.dao.BaseDAO;
import com.car.training.enums.UserType;
import com.car.training.service.AutobotService;
import com.car.training.service.TrainerService;
import com.car.training.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * Created by bill on 11/3/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BaseDAO baseDAO;

    @Autowired
    TrainerService trainerService;
    
    @Autowired
    AutobotService autobotService;
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public LoginUser login(String username, String password) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return (LoginUser) baseDAO.findOne(LoginUser.class, map);
    }

    @Override
    @Transactional
    public boolean existUser(String username, UserType userType) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("userType", userType);
        return baseDAO.findOne(LoginUser.class, map) != null;
    }

    @Override
    @Transactional
    public boolean existUser(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        return baseDAO.findOne(LoginUser.class, map) != null;
    }

    @Override
    @Transactional
    public LoginUser getUser(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        return (LoginUser) baseDAO.findOne(LoginUser.class, map);
    }

    @Override
    @Transactional
    public PersonInfo getPersonInfo(int uid) {
        Trainer trainer = trainerService.findByUId(uid);
        if(trainer !=null){
            return trainer.getPersonInfo();
        }
        Autobot autobot = autobotService.findByUId(uid);
        if(autobot !=null){
            return autobot.getPersonInfo();
        }
        return null;
    }

    @Override
    @Transactional
    public boolean updatePassword(String username, String newPassword) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "update LoginUser set password = :password where username = :username";
        int ret = session.createQuery(hql).setString("password", newPassword)
                .setString("username", username).executeUpdate();
        return ret >= 1;
    }

    @Override
    @Transactional
    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "update LoginUser set password = :password where username = :username and password = :oldPassword";
        int ret = session.createQuery(hql).setString("password", newPassword)
                .setString("username", username).setString("oldPassword", oldPassword).executeUpdate();
        return ret >= 1;
    }
}
