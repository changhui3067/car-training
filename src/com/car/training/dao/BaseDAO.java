package com.car.training.dao;

/**
 * Created by bill on 11/3/16.
 */

import org.hibernate.Session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BaseDao {

    Session getSession();

    Session getNewSession();

    void flush();

    void clear();

    Object load(Class c, Serializable id);

    List getAllList(Class c);

    Long getTotalCount(Class c);

    void save(Object bean);

    void update(Object bean);

    void delete(Object bean);

    void delete(Class c, Serializable id);

    void delete(Class c, String[] ids);

    //查找  满足attribute=value条件组的值
    List find(Class c, HashMap<String, String> condition);

    Object findOne(Class clazz, Map<String, String> condition);

    //删除 满足 attribute=value条件组的值
    void delete(Class c, HashMap<String, String> condition);
}