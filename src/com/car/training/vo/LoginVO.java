package com.car.training.vo;

import com.car.training.enums.UserType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bill on 11/8/16.
 */
public class LoginVO {
    private int id;
    private String username;
    private UserType userType;
    private boolean loggedIn = true;

    public LoginVO(int id, String username, UserType userType) {
        this.id = id;
        this.username = username;
        this.userType = userType;
    }

    public void logOut() {
        id = -1;
        username = null;
        userType = null;
        loggedIn = false;
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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
