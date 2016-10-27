package com.car.training.service;

import com.car.training.domain.TopicComment;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.remoting.Remoting;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(12)
@Remoting
public interface TopicCommentService {

    /**
     * 新增专题评论信息
     */
    void save(TopicComment topicComment);

    /**
     * 更新专题评论信息
     */
    void update(TopicComment topicComment);

    /**
     * 删除专题评论信息
     */
    void delete(String id);

    /**
     * 获取专题评论信息
     **/
    TopicComment findById(String id);

    /**
     * 获取专题评论列表
     */
    ResultPage<TopicComment> findPageByTopicComment(TopicComment topicComment, Integer pageSize, Integer pageNo);

    /**
     * 获取专题评论列表
     */
    List<TopicComment> findListByTopicComment(TopicComment topicComment);

}
