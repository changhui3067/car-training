package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Job;
import com.car.training.service.JobService;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by freyjachang on 11/19/16.
 */
@AutoConfig
public class ApplyJobHistoryAction extends SimpleAction {

    @Autowired
    JobService jobService;

    private List<Job> jobList;

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    @Override
    protected boolean needLogin(){
        return true;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
}
