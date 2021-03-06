package com.car.training.dao;

/**
 * Created by bill on 11/3/16.
 */

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BaseDAO {

    Session getSession();

    Session getNewSession();

    Object load(Class c, Serializable id);

    List getAllList(Class c);

    Long getTotalCount(Class c);

    void save(Object bean);

    void update(Class c, Serializable id, String fieldName, Object newVal);

    void delete(Object bean);


    void delete(Class c, String[] ids);

    //查找  满足attribute=value条件组的值
    List find(Class clazz, HashMap<String, Object> condition);

    Object findOne(Class clazz, Map<String, Object> condition);
}