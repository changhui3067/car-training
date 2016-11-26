package com.car.training.utils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bill on 11/26/16.
 */
public class PaginationUtil {
    public static int DEFAULT_PAGE_SIZE = 20;
    public static int rowCount(DetachedCriteria dc , Session session) {
        Criteria criteria = dc.getExecutableCriteria(session);
        criteria.setProjection(Projections.rowCount());
        return (int)(long) criteria.uniqueResult();
    }

    public static List listAtPage(DetachedCriteria dc, int pageNo,Session session) {
        if(pageNo <1 ){
            return new ArrayList();
        }
        pageNo --;
        Criteria criteria = dc.getExecutableCriteria(session);
        criteria.setFirstResult(pageNo * DEFAULT_PAGE_SIZE);
        criteria.setMaxResults(DEFAULT_PAGE_SIZE);
        return criteria.list();
    }
}
