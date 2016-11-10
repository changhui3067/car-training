package com.car.training.service.impl;

import com.car.training.bean.Autobot;
import com.car.training.dao.BaseDAO;
import com.car.training.service.AutobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by bill on 11/4/16.
 */
@Service
public class AutobotServiceImpl implements AutobotService {

    @Autowired
    BaseDAO baseDAO;

    @Override
    public Autobot findById(int id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        return (Autobot) baseDAO.findOne(Autobot.class,map);
    }
}
