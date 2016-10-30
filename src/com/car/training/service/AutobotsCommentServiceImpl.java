package com.car.training.service;

import com.car.training.domain.Autobots;
import com.car.training.domain.AutobotsComment;
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
public class AutobotsCommentServiceImpl implements AutobotsCommentService {

    @Autowired
    private AutobotsCommentManager autobotsCommentManager;

    /**
     * 新增汽车人信息
     */
    @Override
    @Timing
    @Transactional
    public void save(AutobotsComment autobotsComment) {
        com.car.training.model.AutobotsComment target = new com.car.training.model.AutobotsComment();
        BeanUtils.copyProperties(autobotsComment, target);
        autobotsCommentManager.save(target);
    }

    /**
     * 更新汽车人信息
     */
    @Override
    @Timing
    @Transactional
    public void update(AutobotsComment autobotsComment) {
        this.save(autobotsComment);
    }

    /**
     * 删除汽车人信息
     */
    @Override
    @Timing
    @Transactional
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            com.car.training.model.AutobotsComment target = new com.car.training.model.AutobotsComment();
            target = autobotsCommentManager.get(id);
            autobotsCommentManager.delete(target);
        }
    }

    /**
     * 获取汽车人信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public AutobotsComment findById(String id) {
        com.car.training.model.AutobotsComment source = autobotsCommentManager.get(id);
        if (source == null) {
            return null;
        }
        AutobotsComment target = new AutobotsComment();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取汽车人列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public ResultPage<AutobotsComment> findPageByAutobotsComment(AutobotsComment autobotsComment, Integer pageSize,
                                                                 Integer pageNo) {
        ResultPage<AutobotsComment> tResultPage = null;
        ResultPage<com.car.training.model.AutobotsComment> sResultPage = new ResultPage<com.car.training.model.AutobotsComment>();
        com.car.training.model.AutobotsComment target = new com.car.training.model.AutobotsComment();
        BeanUtils.copyProperties(autobotsComment, target);

        sResultPage = autobotsCommentManager.findPageByAutobotsComment(target, pageSize, pageNo);

        if (sResultPage != null) {
            tResultPage = new ResultPage<AutobotsComment>();
            tResultPage = ResultPageBeanUtils.copyProperties(sResultPage);
            if (sResultPage.getResult() != null) {
                tResultPage
                        .setResult(ResultPageBeanUtils.copyAutobotsCommentPropertiesToRemote(sResultPage.getResult()));
            }
        }
        return tResultPage;
    }

    /**
     * 获取汽车人列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<AutobotsComment> findListByAutobotsComment(AutobotsComment autobotsComment) {
        List<AutobotsComment> resultList = null;
        com.car.training.model.AutobotsComment tAutobotsComment = new com.car.training.model.AutobotsComment();
        BeanUtils.copyProperties(autobotsComment, tAutobotsComment);
        List<com.car.training.model.AutobotsComment> sourceList = autobotsCommentManager
                .findListByAutobotsComment(tAutobotsComment);
        if (sourceList != null) {
            resultList = new ArrayList<AutobotsComment>(sourceList.size());
            for (com.car.training.model.AutobotsComment sourceAutobotsComment : sourceList) {
                AutobotsComment target = new AutobotsComment();
                BeanUtils.copyProperties(sourceAutobotsComment, target);
                if (sourceAutobotsComment != null && sourceAutobotsComment.getAutobots() != null) {
                    Autobots remotingAutobots = new Autobots();
                    BeanUtils.copyProperties(sourceAutobotsComment.getAutobots(), remotingAutobots);
                    target.setAutobots(remotingAutobots);
                }
                resultList.add(target);
            }
        }
        return resultList;
    }

}
