package com.car.training.bean;

import com.car.training.enums.UserType;

import javax.persistence.*;

/**
 * Created by Bill on 11/1/2016.
 */

@Entity
@Table
public class LoginCompany implements LoginBean{
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private UserType type;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
