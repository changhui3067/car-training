package com.car.training.dao;

import com.car.training.bean.Job;
import com.car.training.enums.JobType;
import com.car.training.vo.JobFilter;
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

    List<Job> find(JobFilter jobFilter, int pageNo);

    List<Job> find(JobFilter jobFilter);

    int rowCount(JobFilter jobFilter);

    List find(JobType jobType, Iterable<String> businessCategories, Region region,
              Date minPublishTime, Date maxPublishTime,
              Integer minWorkExperienceRequirement, Integer maxWorkExperienceRequirement, String keyword, int pageNo);

    int rowCount(JobType jobType, Iterable<String> businessCategories, Region region,
                 Date minPublishTime, Date maxPublishTime,
                 Integer minWorkExperienceRequirement, Integer maxWorkExperienceRequirement, String keyword);
}
