package com.car.training.service.impl;

import com.car.training.dao.BaseDAO;
import com.car.training.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bill on 11/30/16.
 */
@Service
public class SimpleServiceImpl implements SimpleService {

    @Autowired
    BaseDAO basedao;

    @Override
    @Transactional
    public void save(Object bean) {
        basedao.save(bean);
    }

    @Override
    @Transactional
    public List getAll(Class clazz){
        return basedao.getAllList(clazz);
    }
}
