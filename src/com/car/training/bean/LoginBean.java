package com.car.training.bean;

import com.car.training.enums.UserType;

/**
 * Created by bill on 11/8/16.
 */
public interface LoginBean {
    int getId();

    void setId(int id);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    UserType getType();

    void setType(UserType type);
}
