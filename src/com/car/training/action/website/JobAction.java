package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Job;
import com.car.training.enums.JobType;
import com.car.training.service.JobService;
import com.car.training.utils.RegionUtils;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bill on 11/14/16.
 */
@AutoConfig
public class JobAction extends SimpleAction {
    @Autowired
    private JobService jobService;

    @Autowired
    private RegionUtils regionUtils;

    private String businessCategory;

    private Integer regionId = null;

    private String publishTime;

    private String workExperienceRequirement;

    private String keyword;

    private List<Region> provinces;

    private List<Job> jobList;

    private int jobId;

    private JobType jobType;

    private int totalPage;

    private int pn=1;

    @Override
    public String execute() throws Exception {
        jobList = jobService.find(jobType, businessCategory,regionId,publishTime,workExperienceRequirement,keyword);
        totalPage = jobService.rowCount(jobType, businessCategory,regionId,publishTime,workExperienceRequirement,keyword);
        provinces = regionUtils.getSubCities(-1);
        return SUCCESS;
    }

    public String search() {
        jobList = jobService.find(jobType, businessCategory,regionId,publishTime,workExperienceRequirement,keyword);
        totalPage = jobService.rowCount(jobType, businessCategory,regionId,publishTime,workExperienceRequirement,keyword);
        return "jobSearchResult";
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = JobType.valueOf(jobType);
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<Region> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Region> provinces) {
        this.provinces = provinces;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getWorkExperienceRequirement() {
        return workExperienceRequirement;
    }

    public void setWorkExperienceRequirement(String workExperienceRequirement) {
        this.workExperienceRequirement = workExperienceRequirement;
    }

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }
}
