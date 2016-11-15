package com.car.training.bean;

import com.car.training.enums.ReactTime;
import org.ironrhino.common.model.Region;

import javax.persistence.*;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table
public class Company {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loginCompany_id", unique = true)
    private LoginUser loginUser;

    @Column
    private String name;

    @Column
    private String address;

    @JoinColumn(name = "regionId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne()
    private Region region;

    @Column
    private String logoUrl;

    @Column
    private String companyType;

    @Column
    private String introduction;

    @Enumerated(EnumType.STRING)
    @Column
    private ReactTime reactTime;

    @Column
    private String welfare;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public ReactTime getReactTime() {
        return reactTime;
    }

    public void setReactTime(ReactTime reactTime) {
        this.reactTime = reactTime;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
