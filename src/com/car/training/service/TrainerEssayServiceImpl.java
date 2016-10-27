package com.car.training.service;

import com.car.training.domain.Trainer;
import com.car.training.domain.TrainerEssay;
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
public class TrainerEssayServiceImpl implements TrainerEssayService {

    @Autowired
    private TrainerEssayManager trainerEssayManager;

    /**
     * 新增培训师文章信息
     */
    @Override
    @Timing
    @Transactional
    public void save(TrainerEssay trainerEssay) {
        com.car.training.model.TrainerEssay target = new com.car.training.model.TrainerEssay();
        BeanUtils.copyProperties(trainerEssay, target);
        trainerEssayManager.save(target);
    }

    /**
     * 更新培训师文章信息
     */
    @Override
    @Timing
    @Transactional
    public void update(TrainerEssay trainerEssay) {
        this.save(trainerEssay);
    }

    /**
     * 删除培训师文章信息
     */
    @Override
    @Timing
    @Transactional
    public void delete(String id) {
        if (StringUtils.isNotBlank(id)) {
            trainerEssayManager.delete(id);
        }
    }

    /**
     * 获取培训师文章信息
     **/
    @Override
    @Timing
    @Transactional(readOnly = true)
    public TrainerEssay findById(String id) {
        com.car.training.model.TrainerEssay source = trainerEssayManager.get(id);
        if (source == null) {
            return null;
        }
        TrainerEssay target = new TrainerEssay();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 获取培训师文章列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public ResultPage<TrainerEssay> findPageByTrainerEssay(TrainerEssay trainerEssay, Integer pageSize, Integer pageNo) {
        ResultPage<TrainerEssay> tResultPage = null;
        ResultPage<com.car.training.model.TrainerEssay> sResultPage = new ResultPage<com.car.training.model.TrainerEssay>();
        com.car.training.model.TrainerEssay target = new com.car.training.model.TrainerEssay();
        BeanUtils.copyProperties(trainerEssay, target);
        sResultPage = trainerEssayManager.findPageByTrainerEssay(target, pageSize, pageNo);

        if (sResultPage != null) {
            tResultPage = new ResultPage<TrainerEssay>();
            tResultPage = ResultPageBeanUtils.copyProperties(sResultPage);

            if (sResultPage.getResult() != null) {
                tResultPage.setResult(ResultPageBeanUtils.copyTrainerEssayPropertiesToRemote(sResultPage.getResult()));
            }
        }
        return tResultPage;
    }

    /**
     * 获取培训师文章列表
     */
    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<TrainerEssay> findListByTrainerEssay(TrainerEssay trainerEssay) {
        List<TrainerEssay> resultList = null;
        com.car.training.model.TrainerEssay tTrainerEssay = new com.car.training.model.TrainerEssay();
        BeanUtils.copyProperties(trainerEssay, tTrainerEssay);
        List<com.car.training.model.TrainerEssay> sourceList = trainerEssayManager
                .findListByTrainerEssay(tTrainerEssay);
        if (sourceList != null) {
            resultList = new ArrayList<TrainerEssay>(sourceList.size());
            for (com.car.training.model.TrainerEssay sourceTrainerEssay : sourceList) {
                TrainerEssay target = new TrainerEssay();
                BeanUtils.copyProperties(sourceTrainerEssay, target);
                resultList.add(target);
            }
        }
        return resultList;
    }

    @Override
    @Timing
    @Transactional(readOnly = true)
    public List<TrainerEssay> findByIndexPromoted(Boolean promote, Integer count) {
        List<TrainerEssay> resultList = null;
        List<com.car.training.model.TrainerEssay> sourceList = trainerEssayManager.findByIndexPromoted(promote, count);
        if (sourceList != null) {
            resultList = new ArrayList<TrainerEssay>(count);

            for (com.car.training.model.TrainerEssay sourceTrainerEssay : sourceList) {
                TrainerEssay target = new TrainerEssay();
                BeanUtils.copyProperties(sourceTrainerEssay, target);
                if (sourceTrainerEssay != null && sourceTrainerEssay.getTrainer() != null) {
                    Trainer trainer = new Trainer();
                    BeanUtils.copyProperties(sourceTrainerEssay.getTrainer(), trainer);
                    target.setTrainer(trainer);
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
