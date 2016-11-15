package com.car.training.service.impl;

import com.car.training.bean.LoginUser;
import com.car.training.dao.BaseDAO;
import com.car.training.enums.UserType;
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
    SessionFactory sessionFactory;

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
    public LoginUser getUser(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        return (LoginUser) baseDAO.findOne(LoginUser.class, map);
    }

    @Override
    @Transactional
    public boolean updatePassword(String username, String newPassword) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "update LoginUser set password = :password where username = :username";

        int ret = session.createQuery(hql).setString("password", newPassword)
                .setString("username", username).executeUpdate();

        session.close();

        return ret >= 1;
    }

    @Override
    @Transactional
    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "update LoginUser set password = :password where username = :username and password = :oldPassword";

        int ret = session.createQuery(hql).setString("password", newPassword)
                .setString("username", username).setString("oldPassword", oldPassword).executeUpdate();

        session.close();

        return ret >= 1;
    }
}
