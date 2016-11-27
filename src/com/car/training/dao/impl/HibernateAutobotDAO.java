package com.car.training.dao.impl;

import com.car.training.bean.Autobot;
import com.car.training.dao.AutobotDAO;
import com.car.training.utils.PaginationUtil;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by bill on 11/12/16.
 */
@Repository
public class HibernateAutobotDAO implements AutobotDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Autobot> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        return search(businessCategory, executionCategory, minAutoYears, maxAutoYears, keyword, 1);
    }

    @Override
    public List<Autobot> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword, int pageNo) {
        DetachedCriteria dc = getCriteria(businessCategory, executionCategory, minAutoYears, maxAutoYears, keyword);
        return PaginationUtil.listAtPage(dc, pageNo, sessionFactory.getCurrentSession());
    }

    @Override
    public int rowCount(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        DetachedCriteria dc = getCriteria(businessCategory, executionCategory, minAutoYears, maxAutoYears, keyword);
        return PaginationUtil.rowCount(dc, sessionFactory.getCurrentSession());
    }


    private DetachedCriteria getCriteria(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Autobot.class, "Autobot");
        criteria.add(getRestriction("businessCategory", businessCategory));
        criteria.add(getRestriction("executionCategory", executionCategory));
        criteria.add(Restrictions.between("autoYears", minAutoYears, maxAutoYears));
        criteria.createAlias("Autobot.personInfo", "personInfo");
        if (!StringUtils.isEmpty(keyword)) {
            criteria.add(Restrictions.like("personInfo.name", "%" + keyword + "%"));
        }
        return criteria;
    }

    private Criterion getRestriction(String categoryName, Set<String> categories) {
        if (categories == null || categories.size() == 0) {
            return Restrictions.and();
        }
        String sql = "this_.id in (select distinct Autobot_id from autobot_%s where %s in(%s))";
        StringBuilder sb = new StringBuilder("''");
        for (String category : categories) {
            sb.append(",\"").append(category).append("\"");
        }
        sql = String.format(sql, categoryName, categoryName, sb.toString());
        return Restrictions.sqlRestriction(sql);
    }
}
