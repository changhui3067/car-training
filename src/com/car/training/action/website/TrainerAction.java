package com.car.training.action.website;

import com.car.training.bean.Trainer;
import com.car.training.service.TrainerService;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AutoConfig
public class TrainerAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TrainerService trainerService;

    /**
     * 按条件筛选培训师列表
     */
    private List<Trainer> trainerList;

    /**
     * 培训经验
     */
    private Integer trainingYears;
    /**
     * 关健字
     */
    private String keyword;

    private String businessCategory;

    private String executionCategory;

    private String autoYears;

    @Override
    public String execute(){
        trainerList = trainerService.search(businessCategory,executionCategory,-1,Integer.MAX_VALUE,keyword);
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
        trainerList = trainerService.search(businessCategory,executionCategory,minAutoYear,maxAutoYear,keyword);
        return "peopleSearchResult";
    }


    public List<Trainer> getTrainerList() {
        return trainerList;
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
