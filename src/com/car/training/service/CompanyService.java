package com.car.training.service;

import com.car.training.bean.Company;
import com.car.training.bean.LoginUser;

/**
 * Created by Bill on 11/13/2016.
 */
public interface CompanyService {
    Company findById(int id);

    Company findByLoginUser(LoginUser loginUser);
}
