package com.car.training.action.website;

import com.car.training.action.SimpleJsonAction;
import com.car.training.bean.Company;
import com.car.training.dao.BaseDAO;
import com.car.training.service.CompanyService;
import com.car.training.bean.Job;
import com.car.training.service.JobService;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Bill on 11/13/2016.
 */
@AutoConfig
public class CompanyDetailAction extends SimpleJsonAction {

    @Autowired
    CompanyService companyService;

    @Autowired
    JobService jobService;

    @Autowired
    BaseDAO baseDAO;

    private Company company;

    private int companyId;

    private List<Job> jobList;

    @Override
    public String execute() throws Exception {
        if(companyId!=0){
            company = companyService.findById(companyId);
            jobList = jobService.findJobsByTargetCompany(companyId);
        }else{
            return redirectToIndex();
        }
        return SUCCESS;
    }


    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Company getCompany() { return company;}

    public void setCompany(Company company) { this.company = company;}

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
}
