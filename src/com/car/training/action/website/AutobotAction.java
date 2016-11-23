package com.car.training.action.website;


import com.car.training.bean.Autobot;
import com.car.training.service.AutobotService;
import com.car.training.utils.CategoriesTransformer;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AutoConfig
public class AutobotAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private AutobotService autobotService;

    /**
     * 按条件筛选汽车人列表
     */
    private List<Autobot> peopleList;




    private Set<String> executionCategories;
    private Set<String> businessCategories;


    /**
     * 汽车行业经验
     */
    private String autoYearRange;
    /**
     * 关健字
     */
    private String keyword;


    @Override
    public String execute() throws Exception {
        peopleList = autobotService.search(businessCategories,executionCategories,-1,Integer.MAX_VALUE,"");
//        Autobots autobots = new Autobots();
//        autobots.setPositionType(positionType);
//        autobots.setAutoYears(autoYears);
//        autobots.setCurrentPosition(keyword);
//        //按条件筛选培训师列表(包含分页)
//        autobotsList = autobotsService.findListByAutobots(autobots);
//        //设置类别枚举值
//        setPositionTypeEnumVal();
        return SUCCESS;
    }

//    public String search(){
//        int minAutoYear;
//        int maxAutoYear;
//        try{
//            String[] arr = autoYears.split(",");
//            minAutoYear = Integer.valueOf(arr[0]);
//            maxAutoYear = Integer.valueOf(arr[1]);
//        } catch (Exception e){
//            minAutoYear = -1;
//            maxAutoYear = Integer.MAX_VALUE;
//        }
//        peopleList = autobotService.search(businessCategories,executionCategories,autoYearRange,keyword);
//        return SUCCESS;
//    }


    public List<Autobot> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Autobot> peopleList) {
        this.peopleList = peopleList;
    }

    public Set<String> getExecutionCategories() {
        return executionCategories;
    }

    public void setExecutionCategories(Set<String> executionCategories) {
        this.executionCategories = executionCategories;
    }
    public void setExecutionCategories(String executionCategories) {
        this.executionCategories = CategoriesTransformer.transform(executionCategories);
    }
    public Set<String> getBusinessCategories() {
        return businessCategories;
    }

    public void setBusinessCategories(Set<String> businessCategory) {
        this.businessCategories = businessCategory;
    }
    
    public void setBusinessCategories(String businessCategory) {
        this.businessCategories = CategoriesTransformer.transform(businessCategory);
    }

    public String getAutoYearRange() {
        return autoYearRange;
    }

    public void setAutoYearRange(String autoYearRange) {
        this.autoYearRange = autoYearRange;
    }

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
