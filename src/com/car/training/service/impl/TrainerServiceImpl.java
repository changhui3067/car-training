package com.car.training.service.impl;

import com.car.training.bean.Trainer;
import com.car.training.dao.BaseDAO;
import com.car.training.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by bill on 11/6/16.
 */
@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    BaseDAO baseDAO;

    @Override
    public Trainer findById(int id) {
        HashMap<String,String> map = new HashMap<>();
        map.put("id",""+id);
        return (Trainer) baseDAO.findOne(Trainer.class,map);
    }
}
