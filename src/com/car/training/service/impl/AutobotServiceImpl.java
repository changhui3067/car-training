package com.car.training.service.impl;

import com.car.training.bean.Autobot;
import com.car.training.dao.BaseDao;
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
    BaseDao baseDao;

    @Override
    public Autobot findById(int id) {
        HashMap<String,String> map = new HashMap<>();
        map.put("id",""+id);
        return (Autobot)baseDao.findOne(Autobot.class,map);
    }
}
