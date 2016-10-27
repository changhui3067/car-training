package com.car.training.service;

import com.car.training.enums.CompanyType;
import com.car.training.exceptions.NotFoundException;
import com.car.training.model.Jobs;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.service.BaseManagerImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class JobsManagerImpl extends BaseManagerImpl<Jobs> implements JobsManager {

    @Override
    @Transactional
    public void save(Jobs obj) {
        super.save(obj);
    }

    @Override
    @Transactional
    public void delete(String id) {
        if (StringUtils.isBlank(id))
            throw new NotFoundException("要删除的对象不存在");
        super.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Jobs findById(String id) {
        if (StringUtils.isBlank(id))
            return null;
        DetachedCriteria dc = detachedCriteria();
        dc.add(Restrictions.eq("enabled", true));
        dc.add(Restrictions.eq("id", id));
        return findByCriteria(dc);
    }

    @Override
    @Transactional(readOnly = true)
    public ResultPage<Jobs> findPageByJobs(Jobs job, Integer pageSize, Integer pageNo) {
        ResultPage<Jobs> resultPage = new ResultPage<Jobs>();
        if (job == null)
            return null;
        DetachedCriteria dc = detachedCriteria();
        if (job.getCompany() != null) {
            dc.createAlias("company", "c").add(Restrictions.eq("c.id", job.getCompany().getId()));
        }
        dc.add(Restrictions.eq("enabled", true));
        dc.addOrder(Order.desc("createDate"));
        resultPage.setCriteria(dc);

        pageSize = ((pageSize == null || pageSize <= 0) ? ResultPage.DEFAULT_PAGE_SIZE : pageSize);
        pageNo = ((pageNo == null || pageNo <= 0) ? 1 : pageNo);
        resultPage.setPageSize(pageSize);
        resultPage.setPageNo(pageNo);
        return findByResultPage(resultPage);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jobs> findListByJobs(Jobs autobotsComment) {
        DetachedCriteria dc = detachedCriteria();
        dc.add(Restrictions.eq("enabled", true));
        dc.addOrder(Order.desc("createDate"));
        return findListByCriteria(dc);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jobs> findListByIndexType(CompanyType type, Integer count) {
        DetachedCriteria dc = detachedCriteria();
        if (type != null) {
            dc.add(Restrictions.eq("companyType", type));
        }
        dc.add(Restrictions.eq("enabled", true));
        dc.addOrder(Order.asc("createDate"));
        return findListByCriteria(dc);
    }
}
