package com.car.training.action.website;

import com.car.training.domain.Jobs;
import com.car.training.enums.BusinessCategory;
import com.car.training.enums.CompanyType;
import com.car.training.enums.JobType;
import com.car.training.enums.PositionType;
import com.car.training.service.JobsService;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.service.EntityManager;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 招聘需求，包括公司招聘培训师的需求和4S店汽车人的需求
 */
@AutoConfig
public class RecruitAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;
    @Autowired
    private JobsService jobsService;
    @Autowired
    private transient EntityManager<Region> entityManager;
    /**
     * 公司招聘职位列表
     */
    private ResultPage<Jobs> jobsCompanyList;
    /**
     * 4S店招聘职位列表
     */
    private ResultPage<Jobs> jobsStoreList;
    /**
     * 岗位类型
     */
    private PositionType positionType;
    /**
     * 招聘职位来源
     */
    private CompanyType companyType;
    /**
     * 职位类型
     */
    private JobType jobType;
    /**
     * 发布时间
     */
    private Date createDate;
    /**
     * 区域
     */
    private Region region;
    /**
     * 执行类别
     */
    private Set<String> executionCategories;
    /**
     * 类别枚举
     */
    private Map<String, Object> businessCategoryEnum;
    /**
     * 关健字
     */
    private String keyword;
    /**
     * 页大小
     */
    private Integer pageSize = 10;
    /**
     * 页号
     */
    private Integer pageNo = 1;

    public String index() throws Exception {
        Jobs jobs = new Jobs();
        Set<Long> regionSet = new HashSet<Long>();
        List<Region> regionList = new ArrayList<Region>();
        if (companyType != null && companyType.getName().equals(CompanyType.COMPANY.getName())) {
            jobs.setCompanyType(CompanyType.COMPANY);// 公司招聘职位
            jobs.setRegion(region);
            jobs.setCreateDate(createDate);
            jobs.setJobType(jobType);
            // jobs.setexe TODO 执行类别
            jobs.setName(keyword);
            // 按条件筛选公司招聘职位列表(包含分页)
            jobsCompanyList = jobsService.findPageByJobs(jobs, pageSize, pageNo);
            //设置显示职位区域
            for (Jobs job : jobsCompanyList.getResult()) {
                if (job.getRegion() != null) {
                    regionSet.add(job.getRegion().getId());
                }
            }
            return "trainerSearch";
        } else if (companyType != null && companyType.getName().equals(CompanyType.STORE.getName())) {
            jobs.setRegion(region);
            jobs.setCreateDate(createDate);
            jobs.setName(keyword);
            jobsStoreList = jobsService.findPageByJobs(jobs, pageSize, pageNo);
            for (Jobs job : jobsStoreList.getResult()) {
                if (job.getRegion() != null) {
                    regionSet.add(job.getRegion().getId());
                }
            }
            return "autobotSearch";
        }
        for (Long ln : regionSet) {
            entityManager.setEntityClass(Region.class);
            Region _region = entityManager.get(ln);
            regionList.add(_region);
        }
        //设置类别枚举值
        setBusinessCategorieEnumVal();

        return "";
    }

    public void setBusinessCategorieEnumVal() {
        businessCategoryEnum = new HashMap<>();
        for (BusinessCategory b : BusinessCategory.values()) {
            businessCategoryEnum.put(b.getName(), b);
        }
    }

    public ResultPage<Jobs> getJobsCompanyList() {
        return jobsCompanyList;
    }

    public void setJobsCompanyList(ResultPage<Jobs> jobsCompanyList) {
        this.jobsCompanyList = jobsCompanyList;
    }

    public ResultPage<Jobs> getJobsStoreList() {
        return jobsStoreList;
    }

    public void setJobsStoreList(ResultPage<Jobs> jobsStoreList) {
        this.jobsStoreList = jobsStoreList;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<String> getExecutionCategories() {
        return executionCategories;
    }

    public void setExecutionCategories(Set<String> executionCategories) {
        this.executionCategories = executionCategories;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public Map<String, Object> getBusinessCategoryEnum() {
        return businessCategoryEnum;
    }

    public void setBusinessCategoryEnum(Map<String, Object> businessCategoryEnum) {
        this.businessCategoryEnum = businessCategoryEnum;
    }
}
