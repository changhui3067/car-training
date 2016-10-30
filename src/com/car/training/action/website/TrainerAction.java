package com.car.training.action.website;

import com.car.training.domain.Trainer;
import com.car.training.enums.BusinessCategory;
import com.car.training.service.TrainerService;
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
    private TrainerService trainerService;

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

    @Override
    public String execute() throws Exception {
        Trainer trainer = new Trainer();
        trainer.setAutoYears(trainingYears);
        trainer.setBusinessCategory(businessCategories);
        trainer.setExecutionCategory(executionCategories);
        trainer.setCurrentPosition(keyword);
        //按条件筛选培训师列表(包含分页)
        trainerList = trainerService.findListByTrainer(trainer);

        //设置类别枚举值
        setBusinessCategorieEnumVal();

        return SUCCESS;
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

}
