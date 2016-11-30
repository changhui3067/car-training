package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Trainer;
import com.car.training.service.TrainerService;
import com.car.training.utils.CategoriesTransformer;
import com.car.training.utils.PaginationUtil;
import com.car.training.vo.PersonVO;
import com.car.training.vo.SearchResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@AutoConfig
public class TrainerAction extends SimpleAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TrainerService trainerService;

    private List<Trainer> peopleList;

    private Integer trainingYears;

    private String keyword;

    private Set<String> businessCategory;

    private Set<String> executionCategory;

    private String autoYears;

    private int totalPage;

    private int pn=1;

    private String resultJson;
    
    @Override
    public String execute() throws JsonProcessingException {
        peopleList = trainerService.search(businessCategory,executionCategory,-1,Integer.MAX_VALUE,keyword);
        totalPage = trainerService.rowCount(businessCategory,executionCategory,-1,Integer.MAX_VALUE,keyword) / PaginationUtil.DEFAULT_PAGE_SIZE +1;
        List<PersonVO> people = PersonVO.fromTrainerList(peopleList);
        SearchResult searchResult = new SearchResult();
        searchResult.setList(people);
        searchResult.setPageCount(totalPage);
        searchResult.setPageNo(pn);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        resultJson = ow.writeValueAsString(searchResult);
        return SUCCESS;
    }
    
    @JsonConfig(root = "data")
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
        peopleList = trainerService.search(businessCategory,executionCategory,minAutoYear,maxAutoYear,keyword,pn);
        totalPage = trainerService.rowCount(businessCategory,executionCategory,minAutoYear,maxAutoYear,keyword) / PaginationUtil.DEFAULT_PAGE_SIZE +1;
        List<PersonVO> people = PersonVO.fromTrainerList(peopleList);
        SearchResult searchResult = new SearchResult();
        searchResult.setList(people);
        searchResult.setPageCount(totalPage);
        searchResult.setPageNo(pn);
        setData(searchResult);
        return JSON;
    }

    public List<Trainer> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Trainer> peopleList) {
        this.peopleList = peopleList;
    }

    public Integer getTrainingYears() {
        return trainingYears;
    }

    public void setTrainingYears(Integer trainingYears) {
        this.trainingYears = trainingYears;
    }

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Set<String> getBusinessCategory() {
        return businessCategory;
    }
    
    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = CategoriesTransformer.transform(businessCategory);
    }
    
    public Set<String> getExecutionCategory() {
        return executionCategory;
    }

    public void setExecutionCategory(String executionCategory) {
        this.executionCategory = CategoriesTransformer.transform(executionCategory);
    }

    public String getAutoYears() {
        return autoYears;
    }

    public void setAutoYears(String autoYears) {
        this.autoYears = autoYears;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setExecutionCategory(Set<String> executionCategory) {
        this.executionCategory = executionCategory;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public String getResultJson() {
        return resultJson;
    }

    public void setResultJson(String resultJson) {
        this.resultJson = resultJson;
    }
}
