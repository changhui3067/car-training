package com.car.training.action.website;

import com.car.training.domain.Trainer;
import com.car.training.enums.BusinessCategory;
import com.car.training.service.TrainerService;
import com.car.training.service.service.TrainerDAOImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AutoConfig
public class TrainerAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TrainerDAOImpl trainerDAO;

    /**
     * 按条件筛选培训师列表
     */
    private List<Trainer> trainerList;

    /**
     * 业务类型
     */
    private Set<String> businessCategories;
    /**
     * 执行类别
     */
    private Set<String> executionCategories;
    /**
     * 培训经验
     */
    private Integer trainingYears;
    /**
     * 关健字
     */
    private String keyword;

    /**
     * 类别枚举
     */
    private Map<String, Object> businessCategoryEnum;

    private String businessCategory;

    private String executionCategory;

    private String autoYears;

    @Override
    public String execute() throws Exception {
        trainerList = trainerDAO.searchUI(businessCategory,executionCategory,-1,Integer.MAX_VALUE,keyword);
        return SUCCESS;
    }

    public String search() {
        int minAutoYear;
        int maxAutoYear;
        try{
            String[] arr = autoYears.split(",");
            minAutoYear = Integer.valueOf(arr[0]);
            maxAutoYear = Integer.valueOf(arr[1]);
        } catch (Exception e){
            minAutoYear = -1;
            maxAutoYear = Integer.MAX_VALUE;
        }
        trainerList = trainerDAO.searchUI(businessCategory,executionCategory,minAutoYear,maxAutoYear,keyword);
        return "peopleSearchResult";
    }

    public void setBusinessCategorieEnumVal() {
        businessCategoryEnum = new HashMap<>();
        for (BusinessCategory b : BusinessCategory.values()) {
            businessCategoryEnum.put(b.getName(), b);
        }
    }

    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public Set<String> getBusinessCategories() {
        return businessCategories;
    }

    public void setBusinessCategories(Set<String> businessCategories) {
        this.businessCategories = businessCategories;
    }

    public Set<String> getExecutionCategories() {
        return executionCategories;
    }

    public void setExecutionCategories(Set<String> executionCategories) {
        this.executionCategories = executionCategories;
    }

    public Integer getTrainingYears() {
        return trainingYears;
    }

    public void setTrainingYears(Integer trainingYears) {
        this.trainingYears = trainingYears;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Map<String, Object> getBusinessCategoryEnum() {
        return businessCategoryEnum;
    }

    public void setBusinessCategoryEnum(Map<String, Object> businessCategoryEnum) {
        this.businessCategoryEnum = businessCategoryEnum;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }

    public String getExecutionCategory() {
        return executionCategory;
    }

    public void setExecutionCategory(String executionCategory) {
        this.executionCategory = executionCategory;
    }

    public String getAutoYears() {
        return autoYears;
    }

    public void setAutoYears(String autoYears) {
        this.autoYears = autoYears;
    }
}
