package com.car.training.dao.impl;

import com.car.training.bean.Autobot;
import com.car.training.bean.Autobot;
import com.car.training.dao.AutobotDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by bill on 11/12/16.
 */
@Repository
public class HibernateAutobotDAO implements AutobotDAO {
    @Autowired
    SessionFactory sessionFactory;

    public List<Autobot> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        Session session = sessionFactory.getCurrentSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Autobot.class,"Autobot");
        Criteria criteria = dc.getExecutableCriteria(session);

        criteria.add(getRestriction("businessCategory",businessCategory));
        criteria.add(getRestriction("executionCategory",executionCategory));
        criteria.add(Restrictions.between("autoYears", minAutoYears, maxAutoYears));
        criteria.createAlias("Autobot.personInfo", "personInfo");
        if (!StringUtils.isEmpty(keyword)) {
            criteria.add(Restrictions.like("personInfo.name", "%"+keyword+"%"));
        }

        return criteria.list();
    }


    private Criterion getRestriction(String categoryName, String cats){
        Criterion criterion = Restrictions.and();
        if (!StringUtils.isEmpty(cats)) {
            String[] categories = cats.split(",");
            for (String category : categories) {
                criterion = Restrictions.or(criterion,Restrictions.like(categoryName, "%"+category+"%"));
            }
        }
        return criterion;
    }
}
