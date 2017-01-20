package com.car.training.bean;

import com.car.training.annotation.Transformer;
import com.car.training.annotation.UIField;

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
    @UIField
    private String currentPosition;

    @Column
    @UIField
    private String education;

    @ElementCollection(fetch = FetchType.LAZY)
    @UIField(transformer = Transformer.CategoryTransformer.class)
    private Set<String> executionCategory;

    @ElementCollection(fetch = FetchType.LAZY)
    @UIField(transformer = Transformer.CategoryTransformer.class)
    private Set<String> businessCategory;

    @Column
    @UIField
    private int autoYears;

    @Column
    @UIField
    private String introduction;

    @Column
    @UIField
    private String mainCourse;

    @Column
    @UIField
    private String videoUrl1;

    @Column
    @UIField
    private String videoUrl2;

    @Column(columnDefinition = "Integer default '0'")
    private int rank = 0;
    
    @Column(columnDefinition = "Integer default '0'")
    private int rank2 = 0;

    @Column(columnDefinition = "Integer default '0'")
    private int rank3 = 0;

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank2() {
        return rank2;
    }

    public void setRank2(int rank2) {
        this.rank2 = rank2;
    }

    public int getRank3() {
        return rank3;
    }

    public void setRank3(int rank3) {
        this.rank3 = rank3;
    }
}
