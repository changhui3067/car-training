package com.car.training.service;

import com.car.training.model.TopicComment;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.service.BaseManager;

import java.util.List;

public interface TopicCommentManager extends BaseManager<TopicComment> {

    /**
     * 新增企业/公司信息
     */
    void save(TopicComment topicComment);

    /**
     * 更新企业/公司信息
     */
    void update(TopicComment topicComment);

    /**
     * 删除企业/公司信息
     */
    void delete(String id);

    /**
     * 获取企业/公司信息
     **/
    TopicComment findById(String id);

    /**
     * 获取企业/公司列表
     */
    ResultPage<TopicComment> findPageByTopicComment(TopicComment topicComment, Integer pageSize, Integer pageNo);

    /**
     * 获取企业/公司列表
     */
    List<TopicComment> findListByTopicComment(TopicComment topicComment);

}
