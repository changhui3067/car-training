package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Apply;
import com.car.training.bean.Company;
import com.car.training.bean.Job;
import com.car.training.service.JobApplyService;
import com.car.training.service.JobService;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by freyjachang on 11/13/16.
 */
@AutoConfig
public class JobDetailAction extends SimpleAction {
    @Autowired
    private JobService jobService;
    
    @Autowired
    private JobApplyService jobApplyService;

    private Job job;

    private Company company;

    private int jobId;

    private int applyStatus; // 0 for cannot apply 1 for can apply 2 to applied  
    
    @Override
    public String execute() throws Exception {
        if(jobId!=0){
            job = jobService.findById(jobId);
            company = job.getCompany();
        }else{
            return redirectToIndex();
        }
        if (isloggedIn() && getLoginVO().getUserType().toString().equals(job.getType().toString())){
            applyStatus = jobApplyService.isApplied(jobId,getLoginVO().getId()) ? 2 : 1;
        }else {
            applyStatus = 0;
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


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }
}
