package com.car.training.service.impl;

import com.car.training.bean.Autobot;
import com.car.training.bean.Company;
import com.car.training.bean.Job;
import com.car.training.bean.Trainer;
import com.car.training.dao.BaseDAO;
import com.car.training.dao.PromotionDAO;
import com.car.training.enums.JobType;
import com.car.training.service.JobService;
import com.car.training.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bill on 11/6/16.
 */
@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    BaseDAO baseDAO;
    @Autowired
    JobService jobService;

    @Autowired
    PromotionDAO promotionDAO;

    final static String PROMOTION_TRAINER = "TRAINER";
    final static String PROMOTION_AUTOBOT = "AUTOBOT";
    final static String PROMOTION_COMPANY = "COMPANY";
    final static String PROMOTION_STORE = "STORE";
    final static String PROMOTION_AUTOBOT_JOB = "AUTOBOT_JOB";
    final static String PROMOTION_TRAINER_JOB = "TRAINER_JOB";


    @Override
    @Transactional
    public List<Trainer> getTopTrainer(int number) {
        return promotionDAO.getTopUser(Trainer.class);
    }

    @Override
    @Transactional
    public List<Autobot> getTopAutobot(int number) {
        return promotionDAO.getTopUser(Autobot.class);
    }

    @Override
    @Transactional
    public List<Job> getTopTrainerJob(int number) {
        return promotionDAO.getTopJob("TRAINER_JOB");
    }

    @Override
    @Transactional
    public List<Job> getTopAutobotJob(int number) {
        return promotionDAO.getTopJob("AUTOBOT_JOB");
    }

    @Override
    @Transactional
    public List<Company> getTopCompany(int number) {
        return baseDAO.getAllList(Company.class);
    }

    @Override
    @Transactional
    public void checkUpdate(){
        if( !promotionDAO.isUpTodate() ){
            update();
        }
    }

    private synchronized void update(){
        if(!promotionDAO.isUpTodate()){
            promotionDAO.updatePromotion();
        }
    }
}
