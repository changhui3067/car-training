package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Apply;
import com.car.training.bean.Job;
import com.car.training.bean.PersonInfo;
import com.car.training.bean.Trainer;
import com.car.training.enums.JobType;
import com.car.training.service.JobApplyService;
import com.car.training.service.JobService;
import com.car.training.utils.BeanOperation;
import com.car.training.vo.LoginVO;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;

/**
 * Created by freyjachang on 11/19/16.
 */
@AutoConfig
public class PublishJobHistoryAction extends BaseAction {
    @Autowired
    private LoginVO loginVO;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobApplyService jobApplyService;

    @Autowired
    BeanOperation beanOperation;

    private List<Job> jobList;

    private HashMap<Object, List<Apply>> jobApplyMap = new HashMap<>();

    //史上最丑的代码
    private String title;
    private String businessCategory;
    private String educationRequirement;
    private int workExperienceRequirement;
    private String LanguageRequirement;
    private String address;
    private String salary;
    private String jobDescription;


    @Override
    public String execute() throws Exception {
        //Object loginVO = getLoginVO();
        if(loginVO != null) {
            jobList = jobService.findJobsByTargetCompany();
            generateJobApplyMap();
        }

        return "publishJobHistory";
    }

    public String add() throws Exception {
        Job job = new Job();

        beanOperation.setValue(this, job, jobProps);
        switch (loginVO.getUserType()) {
            case COMPANY:
                job.setType(JobType.TRAINER);
                break;
            case STORE:
                job.setType(JobType.AUTOBOT);
                break;
        }
        jobService.save(job);
        jobList = jobService.findJobsByTargetCompany();
        generateJobApplyMap();
        return "publishJobHistory";
    }

    private void generateJobApplyMap() {
        for(Job job : jobList) {
            List<Apply> applyList = jobApplyService.getApplyListByJob(job);
            jobApplyMap.put(job, applyList);
        }
    }

    private final static String[] jobProps = new String[]{
            "title",
            "businessCategory",
            "educationRequirement",
            "workExperienceRequirement",
            "LanguageRequirement",
            "address",
            "salary",
            "jobDescription"
    };

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public HashMap<Object, List<Apply>> getJobApplyMap() {
        return jobApplyMap;
    }

    public void setJobApplyMap(HashMap<Object, List<Apply>> jobApplyMap) {
        this.jobApplyMap = jobApplyMap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }
    public String getEducationRequirement() {
        return educationRequirement;
    }

    public void setEducationRequirement(String educationRequirement) {
        this.educationRequirement = educationRequirement;
    }

    public int getWorkExperienceRequirement() {
        return workExperienceRequirement;
    }

    public void setWorkExperienceRequirement(int workExperienceRequirement) {
        this.workExperienceRequirement = workExperienceRequirement;
    }

    public String getLanguageRequirement() {
        return LanguageRequirement;
    }

    public void setLanguageRequirement(String languageRequirement) {
        LanguageRequirement = languageRequirement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
