package com.car.training.service.service;

import com.car.training.domain.Trainer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.ironrhino.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 11/5/2016.
 */
@Component
public class TrainerDAOImpl {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Trainer> searchUI(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        ArrayList<Trainer> trainerArrayList = new ArrayList<>();
        List<com.car.training.model.Trainer> list = search(businessCategory, executionCategory, minAutoYears, maxAutoYears, keyword);
        for (com.car.training.model.Trainer dbtrainer : list ) {
            Trainer trainer = new Trainer();
            BeanUtils.copyProperties(dbtrainer, trainer);
            trainerArrayList.add(trainer);
        }
        return trainerArrayList;
    }

    @Transactional
    public List<com.car.training.model.Trainer> search(String businessCategory, String executionCategory, int minAutoYears, int maxAutoYears, String keyword) {
        Session session = sessionFactory.getCurrentSession();
        DetachedCriteria dc = DetachedCriteria.forClass(com.car.training.model.Trainer.class);
        Criteria criteria = dc.getExecutableCriteria(session);

        criteria.add(Restrictions.sqlRestriction("businessCategory" + toReg(businessCategory)));
        criteria.add(Restrictions.sqlRestriction("executionCategory" + toReg(executionCategory)));
        criteria.add(Restrictions.between("autoYears", minAutoYears, maxAutoYears));
//        criteria.createAlias("UserCenter.name", "name");
//        if (!StringUtils.isEmpty(keyword)) {
//            criteria.add(Restrictions.like("name", keyword));
//        }

//        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }


    String toReg(String cats) {
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
