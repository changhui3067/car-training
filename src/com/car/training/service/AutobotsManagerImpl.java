package com.car.training.service;

import com.car.training.exceptions.NotFoundException;
import com.car.training.model.Autobots;
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
public class AutobotsManagerImpl extends BaseManagerImpl<Autobots> implements AutobotsManager {

    @Override
    @Transactional
    public void save(Autobots obj) {
        super.save(obj);
    }

    @Override
    @Transactional
    public void update(Autobots obj) {
        super.update(obj);
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
    public Autobots findById(String id) {
        if (StringUtils.isBlank(id))
            return null;
        DetachedCriteria dc = detachedCriteria();
        dc.add(Restrictions.eq("id", id));
        return findByCriteria(dc);
    }

    @Override
    @Transactional(readOnly = true)
    public Autobots findByUserCenter(String uid) {
        if (StringUtils.isBlank(uid))
            return null;
        DetachedCriteria dc = detachedCriteria();
        dc.createAlias("userCenter", "uc").add(Restrictions.eq("uc.id", uid));
        return findByCriteria(dc);
    }

    @Override
    @Transactional(readOnly = true)
    public ResultPage<Autobots> findPageByAutobots(Autobots autobotsComment, Integer pageSize, Integer pageNo) {
        ResultPage<Autobots> resultPage = new ResultPage<Autobots>();
        if (autobotsComment == null)
            return null;
        DetachedCriteria dc = detachedCriteria();
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
    public List<Autobots> findListByAutobots(Autobots autobotsComment) {
        DetachedCriteria dc = detachedCriteria();
        dc.addOrder(Order.desc("createDate"));
        return findListByCriteria(dc);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Autobots> findByIndexPromoted(Boolean promote, Integer count) {
        DetachedCriteria dc = detachedCriteria();
        if (count != null && count > 0) {
        }
        if (promote != null) {
            dc.add(Restrictions.eq("promoted", promote));
        }
        dc.addOrder(Order.asc("promoted"));
        return findListByCriteria(dc);
    }
}
