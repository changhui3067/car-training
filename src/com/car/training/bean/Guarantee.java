package com.car.training.bean;

import javax.persistence.*;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userId","companyId"}))
public class Guarantee {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private int userId;

    @Column
    private int companyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Guarantee() {

    }

    public Guarantee(int uid, int companyId) {
        this.userId = uid;
        this.companyId = companyId;
    }
}
