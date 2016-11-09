package com.car.training.bean;

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
    @JoinColumn(unique = true)
    private LoginCompany loginCompany;


    @Column
    private String name;

    @Column
    private String address;

    @Column
    private int regionId;

    @Column
    private String logoUrl;

    @Column
    private String companyType;

    @Column
    private String introduction;


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

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
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


    public LoginCompany getLoginCompany() {
        return loginCompany;
    }

    public void setLoginCompany(LoginCompany loginCompany) {
        this.loginCompany = loginCompany;
    }
}
