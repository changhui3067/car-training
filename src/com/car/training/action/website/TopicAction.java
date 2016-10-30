package com.car.training.action.website;

import com.car.training.domain.Topic;
import com.car.training.service.TopicService;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@AutoConfig
public class TopicAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TopicService topicService;
    /**
     * 专题列表
     */
    private ResultPage<Topic> topicList;
    /**
     * 热点专题列表
     */
    private List<Topic> topicHotList;
    /**
     * 页大小
     */
    private Integer pageSize = 10;
    /**
     * 页号
     */
    private Integer pageNo = 1;

    @Override
    public String execute() throws Exception {
        //专题列表(包含分页)
        topicList = topicService.findPageByTopic(new Topic(), pageSize, pageNo);

        //热门专题列表(包含分页)
        topicHotList = topicService.findListByIndexTopic(8);

        return SUCCESS;
    }

    public ResultPage<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(ResultPage<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<Topic> getTopicHotList() {
        return topicHotList;
    }

    public void setTopicHotList(List<Topic> topicHotList) {
        this.topicHotList = topicHotList;
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
}
