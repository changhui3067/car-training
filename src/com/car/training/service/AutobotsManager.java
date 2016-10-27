package com.car.training.service;

import com.car.training.model.Autobots;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.service.BaseManager;

import java.util.List;

public interface AutobotsManager extends BaseManager<Autobots> {

    /**
     * 新增汽车人信息
     */
    void save(Autobots autobots);

    /**
     * 更新汽车人信息
     */
    void update(Autobots autobots);

    /**
     * 删除汽车人信息
     */
    void delete(String id);

    /**
     * 获取汽车人信息
     **/
    Autobots findById(String id);

    /**
     * 获取汽车人信息
     **/
    Autobots findByUserCenter(String uid);

    /**
     * 获取汽车人列表分页
     */
    ResultPage<Autobots> findPageByAutobots(Autobots autobots, Integer pageSize, Integer pageNo);

    /**
     * 获取汽车人列表
     */
    List<Autobots> findListByAutobots(Autobots autobots);

    /**
     * 获取汽车人列表首页推荐5个位置
     */
    List<Autobots> findByIndexPromoted(Boolean promote, Integer count);

}
