package com.car.training.service;

import com.car.training.domain.Autobots;
import com.car.training.domain.UserCenter;
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
public class AutobotsServiceImpl implements AutobotsService {

    @Autowired
    private AutobotsManager autobotsManager;
    @Autowired
    private UserCenterService userCenterServcie;

    /**
     * 新增汽车人信息
     */
    @Override
    @Timing
    @Transactional
    public void save(Autobots autobots) {
        com.car.training.model.Autobots target = new com.car.training.model.Autobots();
        BeanUtils.copyProperties(autobots, target);
        if (autobots.getUserCenter() != null) {
            com.car.training.model.UserCenter uc = new com.car.training.model.UserCenter();
            BeanUtils.copyProperties(autobots.getUserCenter(), uc);
            userCenterServcie.update(autobots.getUserCenter());
        }
        autobotsManager.save(target);
    }

    /**
     * 更新汽车人信息
     */
    @Override
    @Timing
    @Transactional
    public void update(Autobots autobots) {
        com.car.training.model.Autobots target = autobotsManager.findById(autobots.getId());
        BeanUtils.copyProperties(autobots, target);
        if (autobots.getUserCenter() != null) {
            com.car.training.model.UserCenter uc = new com.car.training.model.UserCenter();
            BeanUtils.copyProperties(autobots.getUserCenter(), uc);
            userCenterServcie.update(autobots.getUserCenter());
        }
        autobotsManager.update(target);
    }

    /**
     * 删除汽车人信息
     */
    @Override
    @Timing
    @Transactional
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            com.car.training.model.Autobots target = new com.car.training.model.Autobots();
            target = autobotsManager.get(id);
            autobotsManager.delete(target);
        }
    }

    /**
     * 获取汽车人信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Autobots findById(String id) {
        com.car.training.model.Autobots source = autobotsManager.get(id);
        if (source == null) {
            return null;
        }
        Autobots target = new Autobots();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取汽车人信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Autobots findByUserCenter(String uid) {
        com.car.training.model.Autobots source = autobotsManager.findByUserCenter(uid);
        if (source == null) {
            return null;
        }
        Autobots target = new Autobots();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取汽车人列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public ResultPage<Autobots> findPageByAutobots(Autobots autobots, Integer pageSize, Integer pageNo) {
        ResultPage<Autobots> tResultPage = null;
        ResultPage<com.car.training.model.Autobots> sResultPage = new ResultPage<com.car.training.model.Autobots>();
        com.car.training.model.Autobots target = new com.car.training.model.Autobots();
        BeanUtils.copyProperties(autobots, target);
        sResultPage = autobotsManager.findPageByAutobots(target, pageSize, pageNo);

        if (sResultPage != null) {
            tResultPage = new ResultPage<Autobots>();
            tResultPage = ResultPageBeanUtils.copyProperties(sResultPage);

            if (sResultPage.getResult() != null) {
                tResultPage.setResult(ResultPageBeanUtils.copyAutobotsPropertiesToRemote(sResultPage.getResult()));
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
    public List<Autobots> findListByAutobots(Autobots autobots) {
        List<Autobots> resultList = new ArrayList<>();
        com.car.training.model.Autobots tAutobots = new com.car.training.model.Autobots();
        BeanUtils.copyProperties(autobots, tAutobots);
        List<com.car.training.model.Autobots> sourceList = autobotsManager.findListByAutobots(tAutobots);
        if (sourceList != null) {
            resultList = new ArrayList<Autobots>(sourceList.size());
            for (com.car.training.model.Autobots sourceAutobots : sourceList) {
                Autobots target = new Autobots();
                BeanUtils.copyProperties(sourceAutobots, target);
                resultList.add(target);
            }
        }
        return resultList;
    }

    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<Autobots> findByIndexPromoted(Boolean promote, Integer count) {
        List<Autobots> resultList = null;
        List<com.car.training.model.Autobots> sourceList = autobotsManager.findByIndexPromoted(promote, count);
        if (sourceList != null) {
            resultList = new ArrayList<Autobots>(count);
            for (com.car.training.model.Autobots sourceAutobots : sourceList) {
                Autobots target = new Autobots();
                BeanUtils.copyProperties(sourceAutobots, target);
                if (sourceAutobots != null && sourceAutobots.getUserCenter() != null) {
                    UserCenter remotingUserCenter = new UserCenter();
                    BeanUtils.copyProperties(sourceAutobots.getUserCenter(), remotingUserCenter);
                    target.setUserCenter(remotingUserCenter);
                }
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
