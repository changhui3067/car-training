package com.car.training.action.website;


import com.car.training.bean.Autobot;
import com.car.training.service.AutobotService;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AutoConfig
public class AutobotAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private AutobotService autobotService;

    /**
     * 按条件筛选汽车人列表
     */
    private List<Autobot> autobotList;




    private String executionCategories;
    private String buisnessCategory;


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
        autobotList = autobotService.search(buisnessCategory,executionCategories,-1,Integer.MAX_VALUE,"");
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
//        autobotList = autobotService.search(buisnessCategory,executionCategories,autoYearRange,keyword);
//        return SUCCESS;
//    }


    public List<Autobot> getAutobotList() {
        return autobotList;
    }

    public void setAutobotList(List<Autobot> autobotList) {
        this.autobotList = autobotList;
    }

    public String getExecutionCategories() {
        return executionCategories;
    }

    public void setExecutionCategories(String executionCategories) {
        this.executionCategories = executionCategories;
    }

    public String getBuisnessCategory() {
        return buisnessCategory;
    }

    public void setBuisnessCategory(String buisnessCategory) {
        this.buisnessCategory = buisnessCategory;
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
