package com.car.training.service;

import com.car.training.bean.Autobot;
import com.car.training.bean.Company;
import com.car.training.bean.Job;
import com.car.training.bean.Trainer;

import java.util.List;

/**
 * Created by bill on 11/6/16.
 */
public interface PromotionService {
    List<Trainer> getTopTrainer(int number);
    List<Autobot> getTopAutobot(int number);
    List<Job> getTopTrainerJob(int number);
    List<Job> getTopAutobotJob(int number);
    List<Company> getTopCompany(int number);
}
