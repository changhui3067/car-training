package com.car.training.service;

import com.car.training.domain.Topic;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.remoting.Remoting;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(12)
@Remoting
public interface TopicService {

    /**
     * 新增专题信息
     */
    void save(Topic topic);

    /**
     * 更新专题信息
     */
    void update(Topic topic);

    /**
     * 删除专题信息
     */
    void delete(String id);

    /**
     * 获取专题信息
     **/
    Topic findById(String id);

    /**
     * 获取专题列表
     */
    ResultPage<Topic> findPageByTopic(Topic topic, Integer pageSize, Integer pageNo);

    /**
     * 获取专题列表
     */
    List<Topic> findListByTopic(Topic topic);

    /**
     * 获取专题列表首页推荐
     */
    List<Topic> findListByIndexTopic(Integer count);

}
