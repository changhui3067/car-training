package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Company;
import com.car.training.bean.PersonInfo;
import com.car.training.dao.BaseDAO;
import com.car.training.service.CompanyService;
import com.car.training.bean.Job;
import com.car.training.service.GuaranteeService;
import com.car.training.service.JobService;
import com.car.training.vo.LoginVO;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Bill on 11/13/2016.
 */
@AutoConfig
public class CompanyDetailAction extends SimpleAction {

    @Autowired
    CompanyService companyService;

    @Autowired
    JobService jobService;

    @Autowired
    BaseDAO baseDAO;

    @Autowired
    private GuaranteeService guaranteeService;

    private Company company;

    private int companyId;

    private List<Job> jobList;

    private Boolean guarantee;

    private List<PersonInfo> personList;

    @Override
    public String execute() throws Exception {
        if(companyId!=0){
            company = companyService.findById(companyId);
            jobList = jobService.findJobsByTargetCompany(companyId);
            personList = guaranteeService.findPeronByCompanyId(companyId);
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
            if (loginVO != null) {
                guarantee = guaranteeService.isGuarantee(loginVO.getId(),companyId);
            }
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

    public Boolean getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Boolean guarantee) {
        this.guarantee = guarantee;
    }

    public List<PersonInfo> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonInfo> personList) {
        this.personList = personList;
    }
}
