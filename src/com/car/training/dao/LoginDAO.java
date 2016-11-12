package com.car.training.dao;

import com.car.training.bean.LoginUser;
import com.car.training.enums.UserType;

/**
 * Created by bill on 11/3/16.
 */
public interface LoginDAO {
    LoginUser validate(String username, UserType userType, String password);
}
