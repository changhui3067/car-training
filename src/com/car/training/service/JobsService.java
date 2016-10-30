package com.car.training.service;

import com.car.training.domain.Jobs;
import com.car.training.enums.CompanyType;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.remoting.Remoting;
import org.springframework.core.annotation.Order;

import java.util.List;

@Order(12)
@Remoting
public interface JobsService {

    /**
     * 新增职位信息
     */
    void save(Jobs jobs);

    /**
     * 更新职位信息
     */
    void update(Jobs jobs);

    /**
     * 删除职位信息
     */
    void delete(String id);

    /**
     * 获取职位信息
     **/
    Jobs findById(String id);

    /**
     * 获取职位列表
     */
    ResultPage<Jobs> findPageByJobs(Jobs jobs, Integer pageSize, Integer pageNo);

    /**
     * 获取职位列表
     */
    List<Jobs> findListByJobs(Jobs jobs);

    /**
     * 获取企业/公司列表首页推荐位置2个培训师需求，2个汽车人需求
     */
    List<Jobs> findListByIndexType(CompanyType type, Integer count);

}
