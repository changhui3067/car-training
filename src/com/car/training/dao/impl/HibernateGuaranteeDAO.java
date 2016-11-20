package com.car.training.dao.impl;

import com.car.training.bean.Guarantee;
import com.car.training.bean.PersonInfo;
import com.car.training.dao.BaseDAO;
import com.car.training.dao.GuaranteeDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateGuaranteeDAO implements GuaranteeDAO {

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    BaseDAO baseDAO;

    @Override
    public boolean isGuarantee(PersonInfo personInfo, int companyId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Guarantee.class);
        criteria.add( Restrictions.eq("personInfo", personInfo));
        criteria.add( Restrictions.eq("companyId", companyId));
        criteria.setProjection(Projections.rowCount());
        int count = Math.toIntExact((long)criteria.uniqueResult());
        return count>0;
    }

    @Override
    public boolean guarantee(PersonInfo personInfo, int companyId) {
        Guarantee guarantee = new Guarantee(personInfo, companyId);
        try {
            baseDAO.save(guarantee);
            return true;
        } catch (ConstraintViolationException e) {
            return false;
        }
    }

    @Override
    public boolean unGuarantee(PersonInfo personInfo, int companyId) {
        try{
            Session session= sessionFactory.getCurrentSession();
            String hql = "delete from Guarantee where personInfo = :personInfo and companyId = :companyId";
            session.createQuery(hql).setParameter("personInfo", personInfo).setInteger("companyId",companyId).executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    @Transactional
    public int guaranteeNumber(int companyId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Guarantee.class);
        criteria.add( Restrictions.eq("companyId", companyId));
        criteria.setProjection(Projections.rowCount());
        int count = Math.toIntExact((long)criteria.uniqueResult());
        return count;
    }
}
