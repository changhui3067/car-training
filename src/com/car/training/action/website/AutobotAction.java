package com.car.training.action.website;


import com.car.training.action.SimpleAction;
import com.car.training.bean.Autobot;
import com.car.training.service.AutobotService;
import com.car.training.service.CommentService;
import com.car.training.service.LikeService;
import com.car.training.utils.CategoriesTransformer;
import com.car.training.utils.PaginationUtil;
import com.car.training.vo.PersonVO;
import com.car.training.vo.SearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@AutoConfig
public class AutobotAction extends SimpleAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private AutobotService autobotService;

    private List<Autobot> peopleList;

    private Set<String> executionCategory;
    private Set<String> businessCategory;

    private String autoYears;
    private String keyword;

    private int totalPage;
    private int pn=1;
    private String resultJson;
    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    @Override
    public String execute() throws Exception {
        peopleList = autobotService.search(businessCategory,executionCategory,-1,Integer.MAX_VALUE,"");
        totalPage = autobotService.rowCount(businessCategory,executionCategory,-1,Integer.MAX_VALUE,keyword)/ PaginationUtil.DEFAULT_PAGE_SIZE +1;;
        List<PersonVO> people = PersonVO.fromAutobotList(peopleList,commentService,likeService);
        SearchResult searchResult = new SearchResult();
        searchResult.setList(people);
        searchResult.setPageCount(totalPage);
        searchResult.setPageNo(pn);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        resultJson = ow.writeValueAsString(searchResult);
        return SUCCESS;
    }

    @JsonConfig(root = "data")
    public String search(){
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
        peopleList = autobotService.search(businessCategory,executionCategory,minAutoYear,maxAutoYear,keyword,pn);
        totalPage = autobotService.rowCount(businessCategory,executionCategory,minAutoYear,maxAutoYear,keyword)/ PaginationUtil.DEFAULT_PAGE_SIZE +1;;
        List<PersonVO> people = PersonVO.fromAutobotList(peopleList,commentService,likeService);
        SearchResult searchResult = new SearchResult();
        searchResult.setList(people);
        searchResult.setPageCount(totalPage);
        searchResult.setPageNo(pn);
        setData(searchResult);
        return JSON;
    }


    public List<Autobot> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Autobot> peopleList) {
        this.peopleList = peopleList;
    }

    public Set<String> getExecutionCategory() {
        return executionCategory;
    }
    
    public void setExecutionCategory(String executionCategory) {
        this.executionCategory = CategoriesTransformer.transform(executionCategory);
    }
    public Set<String> getBusinessCategory() {
        return businessCategory;
    }
    
    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = CategoriesTransformer.transform(businessCategory);
    }

    public String getAutoYears() {
        return autoYears;
    }

    public void setAutoYears(String autoYears) {
        this.autoYears = autoYears;
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

    public String getResultJson() {
        return resultJson;
    }

    public void setResultJson(String resultJson) {
        this.resultJson = resultJson;
    }
}
