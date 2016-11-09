package com.car.training.service.impl;

import com.car.training.bean.LoginBean;
import com.car.training.bean.LoginCompany;
import com.car.training.bean.LoginUser;
import com.car.training.dao.BaseDao;
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
    BaseDao baseDao;

    public LoginBean login(String username, boolean isUser, String password) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        if (isUser) {
            return (LoginBean) baseDao.findOne(LoginUser.class, map);
        } else {
            return (LoginBean) baseDao.findOne(LoginCompany.class, map);
        }
    }

    @Override
    public boolean existUser(String username, UserType userType) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        if (userType == UserType.AUTOBOT || userType == UserType.TRAINER) {
            return baseDao.findOne(LoginUser.class, map) != null;
        } else {
            return baseDao.findOne(LoginCompany.class, map) != null;
        }
    }

    @Override
    public LoginBean getUser(String username, UserType userType) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        if (userType == UserType.AUTOBOT || userType == UserType.TRAINER) {
            return (LoginBean) baseDao.findOne(LoginUser.class, map);
        } else {
            return (LoginBean) baseDao.findOne(LoginCompany.class, map);
        }
    }

    @Override
    public boolean updatePassword(String username, UserType userType, String newPassword) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        if (userType == UserType.AUTOBOT || userType == UserType.TRAINER) {
            LoginUser user = (LoginUser) baseDao.findOne(LoginUser.class, map);
            if (user == null) {
                return false;
            }
            user.setPassword(newPassword);
            baseDao.update(user);
        } else {
            LoginCompany company = (LoginCompany) baseDao.findOne(LoginCompany.class, map);
            if (company == null) {
                return false;
            }
            company.setPassword(newPassword);
            baseDao.update(company);
        }
        return true;
    }


}
