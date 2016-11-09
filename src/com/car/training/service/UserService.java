package com.car.training.service;

import com.car.training.bean.LoginBean;
import com.car.training.enums.UserType;

/**
 * Created by bill on 11/3/16.
 */
public interface UserService {
    LoginBean login(String username, boolean isUser, String password);

    boolean existUser(String username,UserType userType);

    LoginBean getUser(String username,UserType userType);

    boolean updatePassword(String username, UserType userType,String newPassword);

}
