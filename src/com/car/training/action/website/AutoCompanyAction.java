package com.car.training.action.website;

import com.car.training.domain.Company;
import com.car.training.domain.Jobs;
import com.car.training.service.CompanyService;
import com.car.training.service.JobsService;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

@AutoConfig
public class AutoCompanyAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private CompanyService CompanyService;

    @Autowired
    private JobsService jobsService;

    private Company company;

    /**
     * 公司招聘职位列表
     */
    private ResultPage<Jobs> jobsCompanyList;

    /**
     * 页大小
     */
    private Integer pageSize = 10;
    /**
     * 页号
     */
    private Integer pageNo = 1;

    @Override
    public String execute() throws Exception {
        Company t = new Company();
        if (company != null && StringUtils.isNotBlank(company.getId())) {
            t.setId(company.getId());
        }
        company = CompanyService.findById(t.getId());
        // 按条件筛选公司招聘职位列表(包含分页)
        jobsCompanyList = jobsService.findPageByJobs(new Jobs(), pageSize, pageNo);

        return SUCCESS;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ResultPage<Jobs> getJobsCompanyList() {
        return jobsCompanyList;
    }

    public void setJobsCompanyList(ResultPage<Jobs> jobsCompanyList) {
        this.jobsCompanyList = jobsCompanyList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

}
