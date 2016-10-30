package com.car.training.service;

import com.car.training.model.TrainerEssay;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.service.BaseManager;

import java.util.List;

public interface TrainerEssayManager extends BaseManager<TrainerEssay> {

    /**
     * 新增培训师文章信息
     */
    void save(TrainerEssay trainerEssay);

    /**
     * 更新培训师文章信息
     */
    void update(TrainerEssay trainerEssay);

    /**
     * 删除培训师文章信息
     */
    void delete(String id);

    /**
     * 获取培训师文章信息
     **/
    TrainerEssay findById(String id);

    /**
     * 获取培训师文章列表
     */
    ResultPage<TrainerEssay> findPageByTrainerEssay(TrainerEssay trainerEssay, Integer pageSize, Integer pageNo);

    /**
     * 获取培训师文章列表
     */
    List<TrainerEssay> findListByTrainerEssay(TrainerEssay trainerEssay);

    /**
     * 获取培训师文章列首页推荐6个位置
     */
    List<TrainerEssay> findByIndexPromoted(Boolean promote, Integer count);

}
