package com.car.training.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bill on 11/30/16.
 */
public interface SimpleService {


    @Transactional
    void save(Object bean);

    @Transactional
    List getAll(Class clazz);
}
