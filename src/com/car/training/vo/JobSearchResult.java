package com.car.training.vo;

import com.car.training.bean.Job;
import com.car.training.service.GuaranteeService;
import com.car.training.utils.BeanOperation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by bill on 11/29/16.
 */
public class JobSearchResult {
    List<JobVO> jobList;
    private int pageCount;
    private int pageNo;

    private static String[] props= new String[]{
            "title",
            "salary",
            "workExperienceRequirement",
            "region",
    };
    
    public List<JobVO> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList ,GuaranteeService gs) {
        this.jobList = new ArrayList<>();
        BeanOperation beanOperation = new BeanOperation();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.CHINA);
        jobList.forEach((job)->{
            JobVO jobVO = new JobVO();
            beanOperation.setValue(job,jobVO,props);
            CompanyVO companyVO = new CompanyVO();
            beanOperation.setAllValue(job.getCompany(),companyVO);
            companyVO.setGuaranteeNumber(gs.guaranteeNumber(job.getCompany().getId()));
            jobVO.setCompany(companyVO);
            jobVO.setCreateDate(sdf.format(job.getCreateDate()));
            this.jobList.add(jobVO);
        });
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
