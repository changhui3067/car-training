package com.car.training.dao;

import com.car.training.bean.Job;
import com.car.training.enums.JobType;
import org.ironrhino.common.model.Region;

import java.util.Date;
import java.util.List;

/**
 * Created by bill on 11/19/16.
 */
public interface JobDAO {

    List<Job> find(JobType jobType, Iterable<String> businessCategories, Region region,
                   Date minPublishTime, Date maxPublishTime,
                   Integer minWorkExperienceRequirement, Integer maxWorkExperienceRequirement, String keyword);
}
