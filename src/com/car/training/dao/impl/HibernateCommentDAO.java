package com.car.training.dao.impl;

import com.car.training.bean.Comment;
import com.car.training.dao.BaseDAO;
import com.car.training.dao.CommentDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by bill on 11/16/16.
 */
@Repository
public class HibernateCommentDAO implements CommentDAO {


    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    BaseDAO baseDAO;

    @Override
    public List<Comment> findCommentByTargetUser(int targetUid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Comment.class);
        criteria.add( Restrictions.eq("targetUserId", targetUid));
        return criteria.list();
    }

    @Override
    public void addComment(int uid, int targetUid, String content){
        Comment comment = new Comment();
        comment.setUserId(uid);
        comment.setContent(content);
        comment.setTargetUserId(targetUid);
        comment.setCreateTime(new Date());
        baseDAO.save(comment);
    }


    @Override
    public void deleteComment(int uid, int commentId){
        Comment comment = new Comment();
        comment.setId(commentId);
        baseDAO.delete(commentId);
    }

    @Override
    public  int commentCount(int targetUid){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Comment.class);
        criteria.add( Restrictions.eq("targetUserId", targetUid));
        criteria.setProjection(Projections.rowCount());
        return Integer.valueOf(criteria.uniqueResult().toString());
    }


}
