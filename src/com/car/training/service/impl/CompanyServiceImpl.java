package com.car.training.service.impl;

import com.car.training.bean.Company;
import com.car.training.bean.LoginUser;
import com.car.training.dao.BaseDAO;
import com.car.training.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * Created by Bill on 11/13/2016.
 */

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    BaseDAO basedao;

    @Override
    @Transactional
    public Company findById(int id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        return (Company) basedao.findOne(Company.class,map);
    }

    @Override
    @Transactional
    public Company findByUId(int uid) {
        HashMap<String,Object> map = new HashMap<>();
        LoginUser loginUser = new LoginUser();
        loginUser.setId(uid);
        map.put("loginUser",loginUser);
        return (Company) basedao.findOne(Company.class,map);
    }


    @Override
    @Transactional
    public Company findByLoginUser(LoginUser loginUser) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("loginUser", loginUser);
        return (Company) basedao.findOne(Company.class,map);
    }
}
