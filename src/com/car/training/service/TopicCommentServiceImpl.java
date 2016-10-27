package com.car.training.service;

import com.car.training.domain.Topic;
import com.car.training.domain.TopicComment;
import com.car.training.utils.ResultPageBeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.core.aop.Timing;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TopicCommentServiceImpl implements TopicCommentService {

    @Autowired
    private TopicCommentManager topicCommentManager;

    /**
     * 新增企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void save(TopicComment topicComment) {
        com.car.training.model.TopicComment target = new com.car.training.model.TopicComment();
        BeanUtils.copyProperties(topicComment, target);
        topicCommentManager.save(target);
    }

    /**
     * 更新企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void update(TopicComment topicComment) {
        this.save(topicComment);
    }

    /**
     * 删除企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            com.car.training.model.TopicComment target = new com.car.training.model.TopicComment();
            target = topicCommentManager.get(id);
            topicCommentManager.delete(target);
        }
    }

    /**
     * 获取企业/公司信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public TopicComment findById(String id) {
        com.car.training.model.TopicComment source = topicCommentManager.get(id);
        if (source == null) {
            return null;
        }
        TopicComment target = new TopicComment();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取企业/公司列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public ResultPage<TopicComment> findPageByTopicComment(TopicComment topicComment, Integer pageSize, Integer pageNo) {
        ResultPage<TopicComment> tResultPage = null;
        ResultPage<com.car.training.model.TopicComment> sResultPage = new ResultPage<com.car.training.model.TopicComment>();
        com.car.training.model.TopicComment target = new com.car.training.model.TopicComment();
        BeanUtils.copyProperties(topicComment, target);
        sResultPage = topicCommentManager.findPageByTopicComment(target, pageSize, pageNo);

        if (sResultPage != null) {
            tResultPage = new ResultPage<TopicComment>();
            tResultPage = ResultPageBeanUtils.copyProperties(sResultPage);

            if (sResultPage.getResult() != null) {
                tResultPage.setResult(ResultPageBeanUtils.copyTopicCommentPropertiesToRemote(sResultPage.getResult()));
            }
        }
        return tResultPage;
    }

    /**
     * 获取企业/公司列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<TopicComment> findListByTopicComment(TopicComment topicComment) {
        List<TopicComment> resultList = null;
        com.car.training.model.TopicComment tTopicComment = new com.car.training.model.TopicComment();
        BeanUtils.copyProperties(topicComment, tTopicComment);
        List<com.car.training.model.TopicComment> sourceList = topicCommentManager
                .findListByTopicComment(tTopicComment);
        if (sourceList != null) {
            resultList = new ArrayList<TopicComment>(sourceList.size());
            for (com.car.training.model.TopicComment sourceTopicComment : sourceList) {
                TopicComment target = new TopicComment();
                BeanUtils.copyProperties(sourceTopicComment, target);
                if (sourceTopicComment != null && sourceTopicComment.getTopic() != null) {
                    Topic topic = new Topic();
                    BeanUtils.copyProperties(sourceTopicComment.getTopic(), topic);
                    target.setTopic(topic);
                }
                resultList.add(target);
            }
        }
        return resultList;
    }

}
