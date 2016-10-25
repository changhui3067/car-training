package com.car.training.action.backend;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.service.EntityManager;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import com.car.training.domain.Company;
import com.car.training.domain.Jobs;
import com.car.training.enums.JobType;
import com.car.training.service.CompanyService;
import com.car.training.service.JobsService;

@AutoConfig
public class PublishJobAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private JobsService jobsService;
    @Autowired
    private transient EntityManager<Region> entityManager;
    @Autowired
    private CompanyService companyService;

    /**
     * 职位
     */
    private Jobs job;

    private List<Region> provinces;

    private List<Region> cities;

    private Object data;

    private Long parentId;

    private String jobType = "";
    private String name = "";
    private String autoBrand = "";
    private String workExprience = "";
    private String salary = "";
    private String languages = "";
    private String welfare = "";
    private String regionId = "";
    private String description = "";

    @Override
    public String execute() throws Exception {
        entityManager.setEntityClass(Region.class);
        DetachedCriteria dc = entityManager.detachedCriteria();
        dc.add(Restrictions.isNull("parent"));
        dc.addOrder(Order.asc("displayOrder"));
        dc.addOrder(Order.asc("name"));
        provinces = entityManager.findListByCriteria(dc);
        return SUCCESS;
    }


    @JsonConfig(root = "data")
    public String save() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Map<String, Object> map = new HashMap<>();
        Company company = (Company) request.getSession().getAttribute("userDetails");
        if (company != null) {
            company = companyService.findById(company.getId());
        }
        if (company.isEnabled()) {
            Jobs job = new Jobs();
            job.setCompany(company);
            job.setCompanyType(company.getCompanyType());
            job.setCreateDate(new Date());
            job.setCreateUser(company.getUsername());
            job.setEnabled(true);
            job.setJobDescription(description);
            job.setJobType(Enum.valueOf(JobType.class, jobType));
            job.setName(name);
            job.setAutoBrand(autoBrand);
            job.setWorkExprience(new Integer(workExprience));
            if (StringUtils.isNotBlank(languages)) {
                Set<String> setStr = new HashSet<>();
                String[] arr = languages.split(",");
                if (arr != null && arr.length > 0) {
                    for (String s : arr) {
                        setStr.add(s);
                    }
                    job.setLanguages(setStr);
                }
            }
            if (StringUtils.isNotBlank(welfare)) {
                Set<String> setStr = new HashSet<String>();
                String[] arr = welfare.split(",");
                if (arr != null && arr.length > 0) {
                    for (String s : arr) {
                        setStr.add(s);
                    }
                    job.setWelfare(setStr);
                }
            }
            job.setPublishDate(new Date());
            if (StringUtils.isNotBlank(regionId)) {
                Region region = new Region();
                region.setId(Long.valueOf(regionId));
                job.setRegion(region);
            }
            job.setSalary(salary);
            jobsService.save(job);

            map.put("code", "200");
            map.put("msg", "保存成功");
        } else {
            map.put("code", "400");
            map.put("msg", "您的资料还没有通过培聘网的审核,暂不能发布职位信息！");
        }
        setData(map);
        return JSON;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public List<Region> getProvinces() {
        return provinces;
    }


    public void setProvinces(List<Region> provinces) {
        this.provinces = provinces;
    }


    public List<Region> getCities() {
        return cities;
    }


    public void setCities(List<Region> cities) {
        this.cities = cities;
    }


    public Object getData() {
        return data;
    }


    public void setData(Object data) {
        this.data = data;
    }


    public Long getParentId() {
        return parentId;
    }


    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public String getWorkExprience() {
        return workExprience;
    }

    public void setWorkExprience(String workExprience) {
        this.workExprience = workExprience;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
