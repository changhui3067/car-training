package com.car.training.service;

import com.car.training.bean.Job;
import com.car.training.enums.JobType;

import java.util.List;

/**
 * Created by freyjachang on 11/13/16.
 */
public interface JobService {


    Job findById(int id);
    List<Job> findAll(JobType jobType);
    List<Job> findJobsByTargetCompany();
    List<Job> findJobsByTargetCompany(int targetCid);
    List<Job> find(JobType jobType, String businessCategories, Integer regionId, String publishTime,
                   String workExperienceRequirement, String keyword);
    void save(Job job);
}
