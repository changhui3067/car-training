package com.car.training.service;

import com.car.training.bean.LoginUser;
import com.car.training.enums.UserType;

/**
 * Created by bill on 11/3/16.
 */
public interface UserService {
    LoginUser login(String username, String password);

    boolean existUser(String username,UserType userType);

    boolean existUser(String username);


    LoginUser getUser(String username);

    boolean updatePassword(String username, String newPassword);

    boolean updatePassword(String username, String oldPassword, String newPassword);
}
