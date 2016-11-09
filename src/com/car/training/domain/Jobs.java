package com.car.training.domain;

import com.car.training.enums.CompanyType;
import com.car.training.enums.Education;
import com.car.training.enums.JobType;
import com.car.training.enums.Major;
import org.ironrhino.common.model.Region;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Jobs implements Serializable {

    private static final long serialVersionUID = -1405570857184708202L;

    private String id;

    /**
     * 职位名称
     **/
    private String name;

    /**
     * 所属公司
     **/
    private Company company;

    private Region region;

    /**
     * 工作年限
     **/
    private Integer workExprience;

    /**
     * 发布日期
     **/
    private Date publishDate;

    /**
     * 学历要求
     **/
    private Education education;

    /**
     * 品牌
     */
    private String autoBrand;

    /**
     * 工作种类
     **/
    private JobType jobType;

    /**
     * 公司职位类别(公司招聘/4S店招聘)
     **/
    private CompanyType companyType;

    /**
     * 兼职开始执行时间
     **/
    private Date startExcutionDate;

    /**
     * 兼职结束执行时间
     **/
    private Date endExecutionDate;

    /**
     * 福利
     **/
    private Set<String> welfare;

    /**
     * 工资
     **/
    private String salary;

    private Set<String> languages;

    private String jobDescription;

    private String reportTo;

    private String department;

    private Integer underling;

    private Major major;

    private Date createDate;

    private Date modifyDate;

    private String createUser;

    private String modifyUser;

    private boolean enabled;

    /**
     * 是否推荐
     **/
    private boolean promoted;

    private Integer deliveryCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public Integer getWorkExprience() {
        return workExprience;
    }

    public void setWorkExprience(Integer workExprience) {
        this.workExprience = workExprience;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public Date getStartExcutionDate() {
        return startExcutionDate;
    }

    public void setStartExcutionDate(Date startExcutionDate) {
        this.startExcutionDate = startExcutionDate;
    }

    public Date getEndExecutionDate() {
        return endExecutionDate;
    }

    public void setEndExecutionDate(Date endExecutionDate) {
        this.endExecutionDate = endExecutionDate;
    }

    public Set<String> getWelfare() {
        return welfare;
    }

    public void setWelfare(Set<String> welfare) {
        this.welfare = welfare;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getReportTo() {
        return reportTo;
    }

    public void setReportTo(String reportTo) {
        this.reportTo = reportTo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getUnderling() {
        return underling;
    }

    public void setUnderling(Integer underling) {
        this.underling = underling;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getDeliveryCount() {
        return deliveryCount;
    }

    public void setDeliveryCount(Integer deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }
}
