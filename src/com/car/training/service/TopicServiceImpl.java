package com.car.training.service;

import com.car.training.domain.Topic;
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
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicManager topicManager;

    /**
     * 新增企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void save(Topic topic) {
        com.car.training.model.Topic target = new com.car.training.model.Topic();
        BeanUtils.copyProperties(topic, target);
        topicManager.save(target);
    }

    /**
     * 更新企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void update(Topic topic) {
        this.save(topic);
    }

    /**
     * 删除企业/公司信息
     */
    @Override
    @Timing
    @Transactional
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            com.car.training.model.Topic target = new com.car.training.model.Topic();
            target = topicManager.get(id);
            topicManager.delete(target);
        }
    }

    /**
     * 获取企业/公司信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Topic findById(String id) {
        com.car.training.model.Topic source = topicManager.get(id);
        if (source == null) {
            return null;
        }
        Topic target = new Topic();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取企业/公司列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public ResultPage<Topic> findPageByTopic(Topic topic, Integer pageSize, Integer pageNo) {
        ResultPage<Topic> tResultPage = null;
        ResultPage<com.car.training.model.Topic> sResultPage = new ResultPage<com.car.training.model.Topic>();
        com.car.training.model.Topic target = new com.car.training.model.Topic();
        BeanUtils.copyProperties(topic, target);
        sResultPage = topicManager.findPageByTopic(target, pageSize, pageNo);

        if (sResultPage != null) {
            tResultPage = new ResultPage<Topic>();
            tResultPage = ResultPageBeanUtils.copyProperties(sResultPage);

            if (sResultPage.getResult() != null) {
                tResultPage.setResult(ResultPageBeanUtils.copyTopicPropertiesToRemote(sResultPage.getResult()));
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
    public List<Topic> findListByTopic(Topic topic) {
        List<Topic> resultList = null;
        com.car.training.model.Topic tTopic = new com.car.training.model.Topic();
        BeanUtils.copyProperties(topic, tTopic);
        List<com.car.training.model.Topic> sourceList = topicManager.findListByTopic(tTopic);
        if (sourceList != null) {
            resultList = new ArrayList<Topic>(sourceList.size());
            for (com.car.training.model.Topic sourceTopic : sourceList) {
                Topic target = new Topic();
                BeanUtils.copyProperties(sourceTopic, target);
                resultList.add(target);
            }
        }
        return resultList;
    }

    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<Topic> findListByIndexTopic(Integer count) {
        List<Topic> resultList = null;
        List<com.car.training.model.Topic> sourceList = topicManager.findListByIndexTopic(count);
        if (sourceList != null) {
            resultList = new ArrayList<Topic>(count);

            for (com.car.training.model.Topic sourceTopic : sourceList) {
                Topic target = new Topic();
                BeanUtils.copyProperties(sourceTopic, target);
                resultList.add(target);
                count--;
                if (count == 0) {
                    break;
                }
            }
        }
        return resultList;
    }

}
