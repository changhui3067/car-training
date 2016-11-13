package com.car.training.service.impl;

import com.car.training.bean.Job;
import com.car.training.bean.Trainer;
import com.car.training.dao.TrainerDAO;
import com.car.training.enums.UserType;
import com.car.training.dao.BaseDAO;
import com.car.training.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by freyjachang on 11/13/16.
 */
@Service
public class JobServiceImpl implements JobService{
    @Autowired
    BaseDAO baseDAO;

//    @Autowired
//    JobDAO jobDAO;

    @Override
    public Job findById(int id) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("id",id);
        return (Job) baseDAO.findOne(Job.class, map);
    }

    @Override
    public List<Job> findJobsByTargetCompany(int targetCid) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("publishCompanyId", targetCid);
        return  baseDAO.find(Job.class, map);
    }

    @Override
    public List<Job> findJobsByTargetCompanyType(UserType userType) {
        return null;
    }
}
