package com.car.training.service.impl;

import com.car.training.bean.LoginUser;
import com.car.training.dao.BaseDAO;
import com.car.training.enums.UserType;
import com.car.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by bill on 11/3/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BaseDAO baseDAO;

    public LoginUser login(String username, String password) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return (LoginUser) baseDAO.findOne(LoginUser.class, map);
    }

    @Override
    public boolean existUser(String username, UserType userType) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("userType", userType);
        return baseDAO.findOne(LoginUser.class, map) != null;
    }

    @Override
    public boolean existUser(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        return baseDAO.findOne(LoginUser.class, map) != null;
    }

    @Override
    public LoginUser getUser(String username, UserType userType) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        return (LoginUser) baseDAO.findOne(LoginUser.class, map);
    }

    @Override
    public boolean updatePassword(String username, UserType userType, String newPassword) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        LoginUser user = (LoginUser) baseDAO.findOne(LoginUser.class, map);
        if (user == null) {
            return false;
        }
        user.setPassword(newPassword);
        baseDAO.update(user);
        return true;
    }


}
