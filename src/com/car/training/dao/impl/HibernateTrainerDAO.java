package com.car.training.dao.impl;

import com.car.training.bean.Trainer;
import com.car.training.dao.TrainerDAO;
import com.car.training.utils.PaginationUtil;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by Bill on 11/5/2016.
 */
@Repository
public class HibernateTrainerDAO implements TrainerDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Trainer> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        return search(businessCategory, executionCategory, minAutoYears, maxAutoYears, keyword, 1);
    }

    @Override
    public List<Trainer> search(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword, int pageNo) {
        DetachedCriteria dc = getCriteria(businessCategory, executionCategory, minAutoYears, maxAutoYears, keyword);
        return PaginationUtil.listAtPage(dc, pageNo, sessionFactory.getCurrentSession());
    }

    @Override
    public int rowCount(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        DetachedCriteria dc = getCriteria(businessCategory, executionCategory, minAutoYears, maxAutoYears, keyword);
        return PaginationUtil.rowCount(dc, sessionFactory.getCurrentSession());
    }


    private DetachedCriteria getCriteria(Set<String> businessCategory, Set<String> executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Trainer.class, "trainer");
        criteria.add(getRestriction("businessCategory", businessCategory));
        criteria.add(getRestriction("executionCategory", executionCategory));
        criteria.add(Restrictions.between("autoYears", minAutoYears, maxAutoYears-1));
        criteria.createAlias("trainer.personInfo", "personInfo");
        if (!StringUtils.isEmpty(keyword)) {
            criteria.add(Restrictions.like("personInfo.name", "%" + keyword + "%"));
        }
        criteria.addOrder(Order.desc("trainer.rank"));
        criteria.addOrder(Order.desc("trainer.rank2"));
        criteria.addOrder(Order.desc("trainer.rank3"));
        return criteria;
    }


    private Criterion getRestriction(String categoryName, Set<String> categories) {
        if (categories != null && categories.size()>0) {
            String sql = "this_.id in (select distinct Trainer_id from Trainer_%s where %s in(%s))";
            StringBuilder sb = new StringBuilder("''");
            for (String category : categories) {
                sb.append(",\"").append(category).append("\"");
            }
            sql = String.format(sql, categoryName, categoryName, sb.toString());
            return Restrictions.sqlRestriction(sql);
        }
        return Restrictions.and();
    }

    private String toReg(String cats) {
        StringBuilder sb = new StringBuilder(" REGEXP '");
        if (!StringUtils.isEmpty(cats)) {
            String[] categories = cats.split(",");
            for (String category : categories) {
                sb.append("(?=.*").append(category).append(")");
            }
        }
        sb.append(".*'");
        return sb.toString();
    }
}
