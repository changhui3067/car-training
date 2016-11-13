package com.car.training.bean;

import javax.persistence.*;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userId","targetUserId"}))
public class Like {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private int userId;

    @Column
    private int targetUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Like(int userId, int targetUserId) {
        this.userId = userId;
        this.targetUserId = targetUserId;
    }

    public Like(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(int targetUserId) {
        this.targetUserId = targetUserId;
    }
}
