package com.car.training.dao.impl;

import com.car.training.bean.LoginUser;
import com.car.training.dao.LoginDAO;
import com.car.training.enums.UserType;
import org.springframework.stereotype.Component;

/**
 * Created by bill on 11/7/16.
 */
@Component
public class HibernateLoginDAO implements LoginDAO {

    @Override
    public LoginUser validate(String username, UserType userType, String password) {
        return null;
    }
}
