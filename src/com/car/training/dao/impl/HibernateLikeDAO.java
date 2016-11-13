package com.car.training.dao.impl;

import com.car.training.bean.Like;
import com.car.training.dao.BaseDAO;
import com.car.training.dao.LikeDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Created by Bill on 11/13/2016.
 */
@Repository
public class HibernateLikeDAO implements LikeDAO {

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    BaseDAO baseDAO;

    @Override
    public boolean isLike(int uidA, int uidB) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Like.class);
        criteria.add( Restrictions.eq("userId", uidA));
        criteria.add( Restrictions.eq("targetUserId", uidB));
        criteria.setProjection(Projections.rowCount());
        int count = Math.toIntExact((long)criteria.uniqueResult());
        return count>0;
    }

    @Override
    public boolean like(int uid, int targetUid) {
        Like like = new Like(uid, targetUid);
        try {
            baseDAO.save(like);
            return true;
        } catch (ConstraintViolationException e) {
            return false;
        }
    }

    @Override
    public boolean unLike(int uid, int targetUid) {
        try{
            Session session= sessionFactory.getCurrentSession();
            String hql = "delete from Like where userId = :uid and targetUserId = : targetUserId";
            session.createQuery(hql).setInteger("userId", uid).setInteger("targetUserId",targetUid).executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public int likeNumber(int targetUid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Like.class);
        criteria.add( Restrictions.eq("targetUserId", targetUid));
        criteria.setProjection(Projections.rowCount());
        int count = Math.toIntExact((long)criteria.uniqueResult());
        return count;
    }
}
