package com.car.training.domain;

import com.car.training.enums.old.PositionType;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Autobots implements Serializable {

    private static final long serialVersionUID = 4029227868768483061L;

    /**
     * 系统Id
     **/
    private String id;

    /**
     * 用户编号外键UserCenter
     **/
    private UserCenter userCenter;

    /**
     * 当前职位
     **/
    private String currentPosition;

    /**
     * 当前工作状态
     **/
    private String currentWorkStatus;

    /**
     * 岗位类型
     **/
    private PositionType positionType;

    /**
     * 当前汽车品牌
     **/
    private String autoBrand;

    /**
     * 擅长领域
     **/
    private Set<String> businessCategory = new HashSet<String>(0);

    /**
     * 关注培训师
     **/
    private String attentionTrainer;

    private List<Trainer> attentionTrainerList;

    /**
     * 公司发起的橄榄枝
     **/
    private String olives;

    /**
     * 汽车行业经验
     **/
    private Integer autoYears;

    /**
     * 是否认证
     **/
    private boolean authFaithed;

    /**
     * 培训经历
     **/
    private String trainingHistroy;

    /**
     * 工作经历
     **/
    private String workingHistroy;

    /**
     * 所获认证
     **/
    private String authHistroy;

    /**
     * 工作照片1
     **/
    private String workPhotoURL1;

    /**
     * 工作照片2
     **/
    private String workPhotoURL2;

    /**
     * 创建日期
     **/
    private Date createDate;

    /**
     * 修改日期
     **/
    private Date modifyDate;

    /**
     * 创建用户
     **/
    private String createUser;

    /**
     * 修改用户
     **/
    private String modifyUser;

    /**
     * 是否推荐
     **/
    private boolean promoted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserCenter getUserCenter() {
        return userCenter;
    }

    public void setUserCenter(UserCenter userCenter) {
        this.userCenter = userCenter;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getCurrentWorkStatus() {
        return currentWorkStatus;
    }

    public void setCurrentWorkStatus(String currentWorkStatus) {
        this.currentWorkStatus = currentWorkStatus;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public Set<String> getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(Set<String> businessCategory) {
        this.businessCategory = businessCategory;
    }

    public Integer getAutoYears() {
        return autoYears;
    }

    public void setAutoYears(Integer autoYears) {
        this.autoYears = autoYears;
    }

    public boolean isAuthFaithed() {
        return authFaithed;
    }

    public void setAuthFaithed(boolean authFaithed) {
        this.authFaithed = authFaithed;
    }

    public String getTrainingHistroy() {
        return trainingHistroy;
    }

    public void setTrainingHistroy(String trainingHistroy) {
        this.trainingHistroy = trainingHistroy;
    }

    public String getWorkingHistroy() {
        return workingHistroy;
    }

    public void setWorkingHistroy(String workingHistroy) {
        this.workingHistroy = workingHistroy;
    }

    public String getAuthHistroy() {
        return authHistroy;
    }

    public void setAuthHistroy(String authHistroy) {
        this.authHistroy = authHistroy;
    }

    public String getWorkPhotoURL1() {
        return workPhotoURL1;
    }

    public void setWorkPhotoURL1(String workPhotoURL1) {
        this.workPhotoURL1 = workPhotoURL1;
    }

    public String getWorkPhotoURL2() {
        return workPhotoURL2;
    }

    public void setWorkPhotoURL2(String workPhotoURL2) {
        this.workPhotoURL2 = workPhotoURL2;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getAttentionTrainer() {
        return attentionTrainer;
    }

    public void setAttentionTrainer(String attentionTrainer) {
        this.attentionTrainer = attentionTrainer;
    }

    public List<Trainer> getAttentionTrainerList() {
        return attentionTrainerList;
    }

    public void setAttentionTrainerList(List<Trainer> attentionTrainerList) {
        this.attentionTrainerList = attentionTrainerList;
    }

    public String getOlives() {
        return olives;
    }

    public void setOlives(String olives) {
        this.olives = olives;
    }
}
