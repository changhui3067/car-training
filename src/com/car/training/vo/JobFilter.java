package com.car.training.vo;

import com.car.training.enums.JobType;
import org.ironrhino.common.model.Region;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by I309994 on 11/26/2016.
 */
public class JobFilter {
    private JobType jobType;
    private Iterable<String> businessCategories;
    private Region region;
    private java.util.Date minPublishTime;
    private Date maxPublishTime;
    private Integer minWorkExperienceRequirement;
    private Integer maxWorkExperienceRequirement;
    private String keyword;

    public static JobFilter from(JobType jobType, String businessCategories, Region region, String publishTime,
                                 String workExperienceRequirement, String keyword) {
        JobFilter jobFilter = new JobFilter();
        jobFilter.jobType = jobType;
        jobFilter.keyword = keyword;
        jobFilter.region = region;
        String[] businessCategoryArray;
        if (StringUtils.isEmpty(businessCategories)) {
            businessCategoryArray = new String[]{};
        } else {
            businessCategoryArray = businessCategories.split(",");
        }
        jobFilter.businessCategories = Arrays.asList(businessCategoryArray);

        if (!StringUtils.isEmpty(publishTime)) {
            String[] publishTimes = publishTime.split(",");
            if (publishTimes.length >= 2) {
                if (!StringUtils.isEmpty(publishTimes[0])) {
                    try {
                        int minDay = Integer.valueOf(publishTimes[0]);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        calendar.add(Calendar.DATE, 0 - minDay);
                        jobFilter.maxPublishTime = calendar.getTime();
                    } catch (Exception ignored) {
                    }
                }
                if (!StringUtils.isEmpty(publishTimes[1])) {
                    try {
                        int maxDay = Integer.valueOf(publishTimes[1]);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date());
                        calendar.add(Calendar.DATE, 0 - maxDay);
                        jobFilter.minPublishTime = calendar.getTime();
                    } catch (Exception ignored) {
                    }
                }
            }
        }
        if (!StringUtils.isEmpty(workExperienceRequirement)) {
            String[] reqs = workExperienceRequirement.split(",");
            if (reqs.length >= 2) {
                try {
                    jobFilter.minWorkExperienceRequirement = Integer.valueOf(reqs[0]);
                } catch (Exception ignored) {

                }
                try {
                    jobFilter.maxWorkExperienceRequirement = Integer.valueOf(reqs[0]);
                } catch (Exception ignored) {

                }
            }
        }

        return jobFilter;
    }

    private JobFilter() {
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Iterable<String> getBusinessCategories() {
        return businessCategories;
    }

    public void setBusinessCategories(Iterable<String> businessCategories) {
        this.businessCategories = businessCategories;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Date getMinPublishTime() {
        return minPublishTime;
    }

    public void setMinPublishTime(Date minPublishTime) {
        this.minPublishTime = minPublishTime;
    }

    public Date getMaxPublishTime() {
        return maxPublishTime;
    }

    public void setMaxPublishTime(Date maxPublishTime) {
        this.maxPublishTime = maxPublishTime;
    }

    public Integer getMinWorkExperienceRequirement() {
        return minWorkExperienceRequirement;
    }

    public void setMinWorkExperienceRequirement(Integer minWorkExperienceRequirement) {
        this.minWorkExperienceRequirement = minWorkExperienceRequirement;
    }

    public Integer getMaxWorkExperienceRequirement() {
        return maxWorkExperienceRequirement;
    }

    public void setMaxWorkExperienceRequirement(Integer maxWorkExperienceRequirement) {
        this.maxWorkExperienceRequirement = maxWorkExperienceRequirement;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
