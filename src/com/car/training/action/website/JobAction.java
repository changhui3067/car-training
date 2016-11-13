package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Job;
import com.car.training.enums.JobType;
import com.car.training.service.JobService;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by bill on 11/14/16.
 */
@AutoConfig
public class JobAction extends SimpleAction {
    @Autowired
    JobService jobService;

    private List<Job> jobList;

    private int jobId;

    private JobType jobType;

    @Override
    public String execute() throws Exception {
        jobList = jobService.findAll(jobType);
        return SUCCESS;
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
}
