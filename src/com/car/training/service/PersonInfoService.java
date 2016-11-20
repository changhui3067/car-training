package com.car.training.service;

import com.car.training.bean.PersonInfo;

/**
 * Created by freyjachang on 11/19/16.
 */
public interface PersonInfoService {
    PersonInfo findByPersonId(int id);
}
