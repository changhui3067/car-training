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

    private List<Autobot> peopleList;

    private Set<String> executionCategories;
    private Set<String> businessCategories;

    private String autoYearRange;
    private String keyword;

    private int totalPage;
    private int pn=1;

    @Override
    public String execute() throws Exception {
        peopleList = autobotService.search(businessCategories,executionCategories,-1,Integer.MAX_VALUE,"");
        totalPage = autobotService.rowCount(businessCategories,executionCategories,-1,Integer.MAX_VALUE,"");
        return SUCCESS;
    }

    public String search(){
        int minAutoYear;
        int maxAutoYear;
        try{
            String[] arr = autoYearRange.split(",");
            minAutoYear = Integer.valueOf(arr[0]);
            maxAutoYear = Integer.valueOf(arr[1]);
        } catch (Exception e){
            minAutoYear = -1;
            maxAutoYear = Integer.MAX_VALUE;
        }

        peopleList = autobotService.search(businessCategories,executionCategories,minAutoYear,maxAutoYear,keyword,pn);
        totalPage = autobotService.rowCount(businessCategories,executionCategories,minAutoYear,maxAutoYear,keyword);
        return SUCCESS;
    }


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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }
}
