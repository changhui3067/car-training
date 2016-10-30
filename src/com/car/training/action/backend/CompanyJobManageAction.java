package com.car.training.action.backend;

import com.car.training.domain.Company;
import com.car.training.domain.DeliveryResume;
import com.car.training.domain.Jobs;
import com.car.training.service.DeliveryResumeService;
import com.car.training.service.JobsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AutoConfig
public class CompanyJobManageAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private JobsService jobsService;
    @Autowired
    private DeliveryResumeService deliveryResumeService;
    /**
     * 职位列表
     */
    private ResultPage<Jobs> jobsList;
    /**
     * 职位
     */
    private Jobs jobs;
    private String ids;
    private Object data;
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
        HttpServletRequest request = ServletActionContext.getRequest();
        Company com = new Company();
        com = (Company) request.getSession().getAttribute("userDetails");
        Jobs searchJob = new Jobs();
        searchJob.setCompany(com);
        jobsList = jobsService.findPageByJobs(searchJob, pageSize, pageNo);
        for (Jobs job : jobsList.getResult()) {
            DeliveryResume deliveryResume = new DeliveryResume();
            deliveryResume.setJobs(job);
            List<DeliveryResume> list = deliveryResumeService.findListByDeliveryResume(deliveryResume);
            job.setDeliveryCount(list.size());
        }
        return SUCCESS;
    }

    /**
     * 职位新增&編輯
     */
    public String jobSave() throws Exception {
        jobsService.save(jobs);
        return SUCCESS;
    }

    /**
     * 职位删除
     */
    public String jobDelete() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String jobId = request.getParameter("jobs.id");
        jobsService.delete(jobId);
        return SUCCESS;
    }

    @JsonConfig(root = "data")
    public String delall() throws Exception {
        if (StringUtils.isNotBlank(ids)) {
            String[] arr = ids.split(",");
            for (String s : arr) {
                if (StringUtils.isNotBlank(s)) {
                    jobsService.delete(s);
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", "200");
        map.put("msg", "删除成功");
        setData(map);
        return JSON;
    }

    public ResultPage<Jobs> getJobsList() {
        return jobsList;
    }

    public void setJobsList(ResultPage<Jobs> jobsList) {
        this.jobsList = jobsList;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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
