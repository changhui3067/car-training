package com.car.training.dao.impl;

import com.car.training.bean.Job;
import com.car.training.dao.JobDAO;
import com.car.training.enums.JobType;
import com.car.training.utils.PaginationUtil;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.ironrhino.common.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by bill on 11/19/16.
 */
@Repository
public class HibernateJobDAO implements JobDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Job> find(JobType jobType, Iterable<String> businessCategories, Region region,
                          Date minPublishTime, Date maxPublishTime,
                          Integer minWorkExperienceRequirement, Integer maxWorkExperienceRequirement, String keyword) {
        return find(jobType, businessCategories, region, minPublishTime, maxPublishTime, minWorkExperienceRequirement, maxWorkExperienceRequirement, keyword, 1);
    }

    @Override
    public List<Job> find(JobType jobType, Iterable<String> businessCategories, Region region,
                          Date minPublishTime, Date maxPublishTime,
                          Integer minWorkExperienceRequirement, Integer maxWorkExperienceRequirement, String keyword, int pageNo) {
        DetachedCriteria criteria = getCriteria(jobType, businessCategories, region, minPublishTime, maxPublishTime, minWorkExperienceRequirement, maxWorkExperienceRequirement, keyword);
        return PaginationUtil.listAtPage(criteria, pageNo, sessionFactory.getCurrentSession());
    }

    @Override
    public int rowCount(JobType jobType, Iterable<String> businessCategories, Region region,
                        Date minPublishTime, Date maxPublishTime,
                        Integer minWorkExperienceRequirement, Integer maxWorkExperienceRequirement, String keyword, int pageNo) {
        DetachedCriteria criteria = getCriteria(jobType, businessCategories, region, minPublishTime, maxPublishTime, minWorkExperienceRequirement, maxWorkExperienceRequirement, keyword);
        return PaginationUtil.rowCount(criteria, sessionFactory.getCurrentSession());
    }

    private DetachedCriteria getCriteria(JobType jobType, Iterable<String> businessCategories, Region region,
                                         Date minPublishTime, Date maxPublishTime,
                                         Integer minWorkExperienceRequirement, Integer maxWorkExperienceRequirement, String keyword) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Job.class);
        criteria.add(Restrictions.eq("type", jobType));
        Conjunction conjunction = Restrictions.and();
        for (String businessCategory : businessCategories) {
            conjunction.add(Restrictions.like("businessCategory", "%" + businessCategory + "%"));
        }
        criteria.add(conjunction);
        if (region != null) {
            criteria.add(Restrictions.eq("region", region));
        }
        if (minPublishTime != null) {
            criteria.add(Restrictions.ge("createDate", minPublishTime));
        }
        if (maxPublishTime != null) {
            criteria.add(Restrictions.lt("createDate", maxPublishTime));
        }
        if (minWorkExperienceRequirement != null) {
            criteria.add(Restrictions.ge("workExperienceRequirement", minWorkExperienceRequirement));
        }
        if (maxWorkExperienceRequirement != null) {
            criteria.add(Restrictions.lt("workExperienceRequirement", maxWorkExperienceRequirement));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.add(Restrictions.like("title", "%" + keyword + "%"));
        }
        return criteria;
    }
}
