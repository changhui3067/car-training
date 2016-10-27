package com.car.training.service;

import com.car.training.domain.Autobots;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.remoting.Remoting;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(12)
@Remoting
public interface AutobotsService {

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
     * 获取汽车人列表
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
