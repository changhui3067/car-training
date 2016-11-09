package com.car.training.vo;

import com.car.training.enums.UserType;

/**
 * Created by bill on 11/8/16.
 */
public class LoginVO {
    private int id;
    private String username;
    private UserType userType;

    public LoginVO(int id, String username, UserType userType) {
        this.id = id;
        this.username = username;
        this.userType = userType;
    }

    public LoginVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
