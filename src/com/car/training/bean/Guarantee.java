package com.car.training.bean;

import javax.persistence.*;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table
public class Guarantee {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @JoinColumn(name = "userId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne()
    private PersonInfo personInfo;

    @Column
    private int companyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Guarantee() {

    }

    public Guarantee(PersonInfo personInfo, int companyId) {
        this.personInfo = personInfo;
        this.companyId = companyId;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
