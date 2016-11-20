package com.car.training.service.impl;

import com.car.training.bean.PersonInfo;
import com.car.training.dao.BaseDAO;
import com.car.training.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    BaseDAO basedao;

    @Override
    @Transactional
    public PersonInfo findByPersonId(int id) {
        HashMap<String,Object> map = new HashMap<>();
        PersonInfo person = new PersonInfo();
        person.setId(id);
        map.put("id",person);
        return (PersonInfo) basedao.find(PersonInfo.class,map);
    }
}
