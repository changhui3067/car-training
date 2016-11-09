package com.car.training.service.impl;

import com.car.training.bean.Autobot;
import com.car.training.bean.Job;
import com.car.training.bean.Trainer;
import com.car.training.dao.BaseDao;
import com.car.training.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bill on 11/6/16.
 */
@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    BaseDao baseDao;


    @Override
    public List<Trainer> getTopTrainer(int number) {
        return baseDao.getAllList(Trainer.class);
    }

    @Override
    public List<Autobot> getTopAutobot(int number) {
        return baseDao.getAllList(Autobot.class);
    }

    @Override
    public List<Job> getTopTrainerJob(int number) {
        return null;
    }

    @Override
    public List<Job> getTopAutobotJob(int number) {
        return null;
    }
}
