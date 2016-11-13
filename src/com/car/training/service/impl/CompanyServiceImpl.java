package com.car.training.service.impl;

import com.car.training.bean.Autobot;
import com.car.training.bean.Company;
import com.car.training.bean.LoginUser;
import com.car.training.dao.BaseDAO;
import com.car.training.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by Bill on 11/13/2016.
 */

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    BaseDAO basedao;

    @Override
    public Company findById(int id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        return (Company) basedao.findOne(Company.class,map);
    }
}
