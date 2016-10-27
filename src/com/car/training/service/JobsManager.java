package com.car.training.service;

import com.car.training.enums.CompanyType;
import com.car.training.model.Jobs;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.service.BaseManager;

import java.util.List;

public interface JobsManager extends BaseManager<Jobs> {

    /**
     * 新增企业/公司信息
     */
    void save(Jobs jobs);

    /**
     * 更新企业/公司信息
     */
    void update(Jobs jobs);

    /**
     * 删除企业/公司信息
     */
    void delete(String id);

    /**
     * 获取企业/公司信息
     **/
    Jobs findById(String id);

    /**
     * 获取企业/公司列表
     */
    ResultPage<Jobs> findPageByJobs(Jobs jobs, Integer pageSize, Integer pageNo);

    /**
     * 获取企业/公司列表
     */
    List<Jobs> findListByJobs(Jobs jobs);

    /**
     * 获取企业/公司列表首页推荐位置2个培训师需求，2个汽车人需求
     */
    List<Jobs> findListByIndexType(CompanyType type, Integer count);

}
