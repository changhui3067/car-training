package com.car.training.service;

import com.car.training.bean.Job;
import com.car.training.enums.UserType;

import java.util.List;

/**
 * Created by freyjachang on 11/13/16.
 */
public interface JobService {
    Job findById(int id);

    List<Job> findJobsByTargetCompany(int targetCid);
    List<Job> findJobsByTargetCompanyType(UserType userType);
}
