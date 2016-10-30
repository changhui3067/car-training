package com.car.training.action.website;

import com.car.training.domain.Topic;
import com.car.training.domain.TopicComment;
import com.car.training.service.TopicCommentService;
import com.car.training.service.TopicService;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@AutoConfig
public class TopicDetailAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicCommentService topicCommentService;

    private Topic topic;
    /**
     * 首页培训学热点专题列表
     */
    private List<Topic> topicList;
    /**
     * 评论列表
     */
    private List<TopicComment> topicCommentList;

    @Override
    public String execute() throws Exception {
        Topic t = new Topic();
        if (topic != null && StringUtils.isNotBlank(topic.getId())) {
            t.setId(topic.getId());
        }
        topic = topicService.findById(t.getId());
        if (topic != null) {
            TopicComment topicComment = new TopicComment();
            topicComment.setTopic(topic);
            topicCommentList = topicCommentService.findListByTopicComment(topicComment);
        }
        //首页热点专题列表6个位置
        topicList = topicService.findListByIndexTopic(6);

        return SUCCESS;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<TopicComment> getTopicCommentList() {
        return topicCommentList;
    }

    public void setTopicCommentList(List<TopicComment> topicCommentList) {
        this.topicCommentList = topicCommentList;
    }


}
