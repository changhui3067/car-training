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
public class Autobot {
    @Id
    @GeneratedValue
    @Column
    private int id;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(unique=true)
    private LoginUser loginUser;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(unique=true)
    private PersonInfo personInfo;

    /**
     * 工作状态  求职/在职
     */
    @Column
    @UIField
    private String workingStatus;

    /**
     * 工作经验
     */
    @Column
    @UIField
    private int autoYears;

    /**
     * 汽车品牌
     */
    @Column
    @UIField
    private String autoBrand;

    /**
     * 擅长领域
     */
    @ElementCollection(fetch = FetchType.LAZY)
    @UIField(transformer = Transformer.CategoryTransformer.class)
    private Set<String> businessCategory;


    /**
     * 认证记录
     */
    @Column
    @UIField
    private String certRecords;

    /**
     * 工作记录
     */
    @Column
    @UIField
    private String workingHistory;

    @Column
    @UIField
    private String currentPosition;

    @Column
    @UIField
    private String trainingHistory;

    @Column
    @UIField
    private String education;

    @Column(columnDefinition = "Integer default '0'")
    private int rank = 0;

    @Column(columnDefinition = "Integer default '0'")
    private int rank2 = 0;

    @Column(columnDefinition = "Integer default '0'")
    private int rank3 = 0;
    
    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }

    public int getAutoYears() {
        return autoYears;
    }

    public void setAutoYears(int autoYears) {
        this.autoYears = autoYears;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public String getCertRecords() {
        return certRecords;
    }

    public void setCertRecords(String certRecords) {
        this.certRecords = certRecords;
    }

    public String getWorkingHistory() {
        return workingHistory;
    }

    public void setWorkingHistory(String workingHistory) {
        this.workingHistory = workingHistory;
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

    public String getTrainingHistory() {
        return trainingHistory;
    }

    public void setTrainingHistory(String trainingHistory) {
        this.trainingHistory = trainingHistory;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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
