package com.car.training.service;

import com.car.training.domain.Trainer;
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
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerManager trainerManager;
    @Autowired
    private UserCenterService userCenterServcie;

    /**
     * 新增培训师信息
     */
    @Override
    @Timing
    @Transactional
    public void save(Trainer trainer) {
        com.car.training.model.Trainer target = new com.car.training.model.Trainer();
        BeanUtils.copyProperties(trainer, target);
        if (trainer.getUserCenter() != null) {
            com.car.training.model.UserCenter uc = new com.car.training.model.UserCenter();
            BeanUtils.copyProperties(trainer.getUserCenter(), uc);
        }
        trainerManager.save(target);
    }

    /**
     * 更新培训师信息
     */
    @Override
    @Timing
    @Transactional
    public void update(Trainer trainer) {
        com.car.training.model.Trainer target = trainerManager.findById(trainer.getId());
        BeanUtils.copyProperties(trainer, target);
        if (trainer.getUserCenter() != null) {
            com.car.training.model.UserCenter uc = new com.car.training.model.UserCenter();
            BeanUtils.copyProperties(trainer.getUserCenter(), uc);
            userCenterServcie.update(trainer.getUserCenter());
        }
        trainerManager.update(target);
    }

    /**
     * 删除培训师信息
     */
    @Override
    @Timing
    @Transactional
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            com.car.training.model.Trainer target = new com.car.training.model.Trainer();
            target = trainerManager.get(id);
            trainerManager.delete(target);
        }
    }

    /**
     * 获取培训师信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Trainer findById(String id) {
        com.car.training.model.Trainer source = trainerManager.get(id);
        if (source == null) {
            return null;
        }
        Trainer target = new Trainer();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取培训师信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public Trainer findByUserCenter(String uid) {
        com.car.training.model.Trainer source = trainerManager.findByUserCenter(uid);
        if (source == null) {
            return null;
        }
        Trainer target = new Trainer();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取培训师列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public ResultPage<Trainer> findPageByTrainer(Trainer trainer, Integer pageSize, Integer pageNo) {
        ResultPage<Trainer> tResultPage = null;
        ResultPage<com.car.training.model.Trainer> sResultPage = new ResultPage<com.car.training.model.Trainer>();
        com.car.training.model.Trainer target = new com.car.training.model.Trainer();
        BeanUtils.copyProperties(trainer, target);
        sResultPage = trainerManager.findPageByTrainer(target, pageSize, pageNo);

        if (sResultPage != null) {
            tResultPage = new ResultPage<Trainer>();
            tResultPage = ResultPageBeanUtils.copyProperties(sResultPage);

            if (sResultPage.getResult() != null) {
                tResultPage.setResult(ResultPageBeanUtils.copyTrainerPropertiesToRemote(sResultPage.getResult()));
            }
        }
        return tResultPage;
    }

    /**
     * 获取培训师列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<Trainer> findListByTrainer(Trainer trainer) {
        List<Trainer> resultList = null;
        com.car.training.model.Trainer tTrainer = new com.car.training.model.Trainer();
        BeanUtils.copyProperties(trainer, tTrainer);
        List<com.car.training.model.Trainer> sourceList = trainerManager.findListByTrainer(tTrainer);
        if (sourceList != null) {
            resultList = new ArrayList<Trainer>(sourceList.size());
            for (com.car.training.model.Trainer sourceTrainer : sourceList) {
                Trainer target = new Trainer();
                BeanUtils.copyProperties(sourceTrainer, target);
                resultList.add(target);
            }
        }
        return resultList;
    }

    @Override
    @Timing
    @Transactional(readOnly = true)
    public Trainer findByIndexPromoted(Boolean promote) {
        com.car.training.model.Trainer source = trainerManager.findByIndexPromoted(promote);
        if (source == null) {
            return null;
        }
        Trainer target = new Trainer();
        BeanUtils.copyProperties(source, target);
        if (source != null && source.getUserCenter() != null) {
            UserCenter remotingUserCenter = new UserCenter();
            BeanUtils.copyProperties(source.getUserCenter(), remotingUserCenter);
            target.setUserCenter(remotingUserCenter);
        }
        return target;
    }

    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<Trainer> findByIndexPromoted(Boolean promote, Integer count) {
        List<Trainer> resultList = null;
        List<com.car.training.model.Trainer> sourceList = trainerManager.findByIndexPromoted(promote, count);
        if (sourceList != null) {
            resultList = new ArrayList<Trainer>(count);

            for (com.car.training.model.Trainer sourceTrainer : sourceList) {
                Trainer target = new Trainer();
                BeanUtils.copyProperties(sourceTrainer, target);
                if (sourceTrainer != null && sourceTrainer.getUserCenter() != null) {
                    UserCenter remotingUserCenter = new UserCenter();
                    BeanUtils.copyProperties(sourceTrainer.getUserCenter(), remotingUserCenter);
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
