package com.car.training.service;

import com.car.training.domain.TrainerEssay;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.remoting.Remoting;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(12)
@Remoting
public interface TrainerEssayService {

    /**
     * 新增专题评论信息
     */
    void save(TrainerEssay trainerEssay);

    /**
     * 更新专题评论信息
     */
    void update(TrainerEssay trainerEssay);

    /**
     * 删除专题评论信息
     */
    void delete(String id);

    /**
     * 获取专题评论信息
     **/
    TrainerEssay findById(String id);

    /**
     * 获取专题评论列表
     */
    ResultPage<TrainerEssay> findPageByTrainerEssay(TrainerEssay trainerEssay, Integer pageSize, Integer pageNo);

    /**
     * 获取专题评论列表
     */
    List<TrainerEssay> findListByTrainerEssay(TrainerEssay trainerEssay);

    /**
     * 获取培训师文章列首页推荐6个位置
     */
    List<TrainerEssay> findByIndexPromoted(Boolean promote, Integer count);

}
