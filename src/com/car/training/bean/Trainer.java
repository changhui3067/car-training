package com.car.training.bean;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table
public class Trainer {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private LoginUser loginUser;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(unique=true)
    private PersonInfo personInfo;

    @Column
    private String currentPosition;

    @Column
    private String education;

    @ElementCollection(fetch = FetchType.LAZY)
    private Set<String> executionCategory;

    @ElementCollection(fetch = FetchType.LAZY)
    private Set<String> businessCategory;

    @Column
    private int autoYears;

    @Column
    private String introduction;

    @Column
    private String mainCourse;

    @Column
    private String videoUrl1;

    @Column
    private String videoUrl2;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    public int getAutoYears() {
        return autoYears;
    }

    public void setAutoYears(int autoYears) {
        this.autoYears = autoYears;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
    }

    public String getVideoUrl1() {
        return videoUrl1;
    }

    public void setVideoUrl1(String videoUrl1) {
        this.videoUrl1 = videoUrl1;
    }

    public String getVideoUrl2() {
        return videoUrl2;
    }

    public void setVideoUrl2(String videoUrl2) {
        this.videoUrl2 = videoUrl2;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Set<String> getExecutionCategory() {
        return executionCategory;
    }

    public void setExecutionCategory(Set<String> executionCategory) {
        this.executionCategory = executionCategory;
    }

    public Set<String> getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Set<String> businessCategory) {
        this.businessCategory = businessCategory;
    }
}
