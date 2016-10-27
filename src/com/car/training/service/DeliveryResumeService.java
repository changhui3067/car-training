package com.car.training.service;

import com.car.training.domain.DeliveryResume;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.remoting.Remoting;

import java.util.List;

@Remoting
public interface DeliveryResumeService {

    /**
     * 新增公开课信息
     */
    void save(DeliveryResume deliveryResume);

    /**
     * 更新公开课信息
     */
    void update(DeliveryResume deliveryResume);

    /**
     * 删除公开课信息
     */
    void delete(String id);

    /**
     * 获取公开课信息
     **/
    DeliveryResume findById(String id);

    /**
     * 获取公开课列表
     */
    ResultPage<DeliveryResume> findPageByDeliveryResume(DeliveryResume deliveryResume, Integer pageSize, Integer pageNo);

    /**
     * 获取公开课列表
     */
    List<DeliveryResume> findListByDeliveryResume(DeliveryResume deliveryResume);

    /**
     * 获取公开课列表首页2个位置
     */
    List<DeliveryResume> findByIndexPromoted(Boolean promote, Integer count);

}
