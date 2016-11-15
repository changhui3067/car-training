package com.car.training.dao.impl;

import com.car.training.dao.BaseDAO;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaDelete;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bill on 11/3/16.
 */
@Repository(value = "BaseDao")
public class HibernateBaseDAO implements BaseDAO {
    @Autowired
    protected SessionFactory sessionFactory;



    /**
     * gerCurrentSession 会自动关闭session，使用的是当前的session事务 * * @return
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * openSession 需要手动关闭session 意思是打开一个新的session * * @return
     */
    public Session getNewSession() {
        return sessionFactory.openSession();
    }

    /**
     * 根据 id 查询信息 * * @param id * @return
     */
    @SuppressWarnings("rawtypes")
    public Object load(Class c, Serializable id) {
        Session session = getNewSession();
        Object reval = session.get(c, id);
        session.close();
        return reval;
    }

    /**
     * 获取所有信息 * * @param c * * @return
     */

    public List getAllList(Class c) {
        String hql = "from " + c.getName();
        Session session = getNewSession();
        List reval = session.createQuery(hql).list();
        session.close();
        return reval;
    }

    /**
     * 获取总数量 * * @param c * @return
     */

    public Long getTotalCount(Class c) {
        Session session = getNewSession();
        String hql = "select count(*) from " + c.getName();
        Long count = (Long) session.createQuery(hql).uniqueResult();
        session.close();
        return count != null ? count : 0;
    }

    /**
     * 保存 * * @param bean *
     */
    public void save(Object bean) {
        try {
            Session session = getNewSession();
            session.saveOrUpdate(bean);
            session.flush();
            session.clear();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除 * * @param bean *
     */
    public void delete(Object bean) {

        Session session = getNewSession();
        session.delete(bean);
        session.flush();
        session.clear();
        session.close();
    }


    /**
     * 批量删除 * * @param c 类 * * @param ids ID 集合 *
     */
    public void delete(Class c, String[] ids) {
        for (String id : ids) {
            Object obj = getSession().get(c, id);
            if (obj != null) {
                getSession().delete(obj);
            }
        }
    }

    public Object findOne(Class clazz, Map<String, Object> condition) {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        for (String property : condition.keySet()) {
            Object value = condition.get(property);
            dc.add(Restrictions.eq(property, value));
        }
        Criteria c = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
        c.setMaxResults(1);
        c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return c.uniqueResult();
    }

    @Transactional
    public List find(Class clazz, HashMap<String, Object> condition) {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        for (String property : condition.keySet()) {
            Object value = condition.get(property);
            dc.add(Restrictions.eq(property, value));
        }
        Criteria criteria = dc.getExecutableCriteria(sessionFactory.getCurrentSession());
        return criteria.list();
    }

}
