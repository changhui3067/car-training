package com.car.training.dao.impl;

import com.car.training.bean.Trainer;
import com.car.training.dao.TrainerDAO;
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
 * Created by Bill on 11/5/2016.
 */
@Repository
public class HibernateTrainerDAO implements TrainerDAO{
    @Autowired
    SessionFactory sessionFactory;

    public List<Trainer> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        Session session = sessionFactory.getCurrentSession();
        DetachedCriteria dc = DetachedCriteria.forClass(Trainer.class,"trainer");
        Criteria criteria = dc.getExecutableCriteria(session);

        criteria.add(getRestriction("businessCategory",businessCategory));
        criteria.add(getRestriction("executionCategory",executionCategory));
        criteria.add(Restrictions.between("autoYears", minAutoYears, maxAutoYears));
        criteria.createAlias("trainer.personInfo", "personInfo");
        if (!StringUtils.isEmpty(keyword)) {
            criteria.add(Restrictions.like("personInfo.name", "%"+keyword+"%"));
        }

//        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }


    private Criterion getRestriction(String categoryName, String cats){
        if (!StringUtils.isEmpty(cats)) {
            String[] categories = cats.split(",");
            String sql = "this_.id in (select distinct Trainer_id from trainer_%s where %s in(%s))";
            StringBuilder sb = new StringBuilder("''");
            for (String category : categories) {
                sb.append(",\"").append(category).append("\"");
            }
            sql = String.format(sql,categoryName,categoryName,sb.toString());
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
