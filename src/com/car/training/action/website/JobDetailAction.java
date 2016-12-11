package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Apply;
import com.car.training.bean.Company;
import com.car.training.bean.Job;
import com.car.training.bean.PersonInfo;
import com.car.training.service.GuaranteeService;
import com.car.training.service.JobApplyService;
import com.car.training.service.JobService;
import com.car.training.vo.LoginVO;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by freyjachang on 11/13/16.
 */
@AutoConfig
public class JobDetailAction extends SimpleAction {
    @Autowired
    private JobService jobService;
    
    @Autowired
    private JobApplyService jobApplyService;

    @Autowired
    private GuaranteeService guaranteeService;

    private List<PersonInfo> personList;

    private Boolean guarantee;

    private Job job;

    private Company company;

    private int jobId;

    private int applyStatus; // 0 for cannot apply 1 for can apply 2 to applied  
    
    @Override
    public String execute() throws Exception {
        if(jobId!=0){
            job = jobService.findById(jobId);
            company = job.getCompany();
            personList = guaranteeService.findPeronByCompanyId(company.getId());
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
            if (loginVO != null) {
                guarantee = guaranteeService.isGuarantee(loginVO.getId(), company.getId());
            }
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

    public List<PersonInfo> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonInfo> personList) {
        this.personList = personList;
    }

    public Boolean getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Boolean guarantee) {
        this.guarantee = guarantee;
    }
}
