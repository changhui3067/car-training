package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Job;
import com.car.training.service.JobService;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by freyjachang on 11/13/16.
 */
@AutoConfig
public class JobDetailAction extends SimpleAction {
    @Autowired
    JobService jobService;

    private Job job;

    private int jobId;

    @Override
    public String execute() throws Exception {
        if(jobId!=0){
            job = jobService.findById(jobId);
        }else{
            return redirectToIndex();
        }
        return SUCCESS;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
