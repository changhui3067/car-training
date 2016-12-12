package com.car.training.bean;

import com.car.training.annotation.Transformer;
import com.car.training.annotation.UIField;
import org.ironrhino.common.model.Region;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table
public class PersonInfo {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loginUser", unique = true)
    private LoginUser loginUser;

    @Column
    @UIField(transformer = Transformer.DateTransformer.class)
    private Date birthday;

    @Column
    @UIField
    private String name;

    @Column
    @UIField
    private String gender;

    @Column
    @UIField
    private String mobile;

    @Column
    @UIField
    private String email;

    @Column
    @UIField
    private String marriageStatus;

    @JoinColumn(name = "regionId",foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne
    private Region region;

    @Column
    private String avatarUrl;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }
}
