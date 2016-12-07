package com.car.training.service;

import com.car.training.bean.Job;
import com.car.training.enums.JobType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by freyjachang on 11/13/16.
 */
public interface JobService {


    Job findById(int id);
    List<Job> findAll(JobType jobType);
    List<Job> findJobsByTargetCompany(int targetCid);
    List<Job> find(JobType jobType, String businessCategories, Integer regionId, String publishTime,
                   String workExperienceRequirement, String keyword);

    List<Job> find(JobType jobType, String businessCategories, Integer regionId, String publishTime,
                   String workExperienceRequirement, String keyword, int pageNo);

    void save(Job job) throws Exception;

    int rowCount(JobType jobType, String businessCategories, Integer regionId, String publishTime, String workExperienceRequirement, String keyword);
}
