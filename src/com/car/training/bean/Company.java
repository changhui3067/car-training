package com.car.training.bean;

import com.car.training.annotation.Transformer;
import com.car.training.annotation.UIField;
import com.car.training.enums.ReactTime;
import org.ironrhino.common.model.Region;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @UIField
    private String name;

    @Column
    @UIField
    private String address;

    @JoinColumn(name = "regionId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne()
    private Region region;

    @Column
    private String logoUrl;

    @Column
    private String companyType;

    @Column
    @UIField
    private String scale;

    @Column
    @UIField
    private String introduction;

    @Enumerated(EnumType.STRING)
    @Column
    private ReactTime reactTime;

//    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    @ManyToOne()
    @Column
    @UIField
    private String welfare;

    @ElementCollection(fetch = FetchType.LAZY)
    @UIField(transformer = Transformer.CategoryTransformer.class)
    private Set<String> businessCategory;

    @Column
    private String photoUrl;

    @Column
    @UIField
    private String autoBrand;

    @Column
    @UIField
    private String businessRange;

    @Column
    @UIField
    private String contactName;

    @Column
    @UIField
    private String telephone;

    @Column
    @UIField
    private String email;


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

    public Set<String> getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Set<String> businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public String getBusinessRange() {
        return businessRange;
    }

    public void setBusinessRange(String businessRange) {
        this.businessRange = businessRange;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
