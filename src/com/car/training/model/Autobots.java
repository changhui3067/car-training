package com.car.training.model;

import com.car.training.enums.PositionType;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.NotInCopy;
import org.ironrhino.core.metadata.UiConfig;
import org.ironrhino.core.model.BaseEntity;
import org.ironrhino.core.search.elasticsearch.annotations.Searchable;
import org.nustaq.serialization.annotations.Version;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Searchable
//@AutoConfig
//@javax.persistence.Entity
//@Table(name = "autobots", indexes = {@javax.persistence.Index(columnList = "uid")})
public class Autobots extends BaseEntity {

    private static final long serialVersionUID = -3908483665308582434L;

    /**
     * 用户编号外键UserCenter
     **/
    @JoinColumn(name = "uid", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    private UserCenter userCenter;

    /**
     * 当前职位
     **/
    @Column(length = 50, nullable = true)
    private String currentPosition;

    /**
     * 当前工作状态
     **/
    @Column(length = 50, nullable = true)
    private String currentWorkStatus;

    /**
     * 当前汽车品牌
     **/
    private String autoBrand;

    /**
     * 擅长领域
     **/
    private Set<String> businessCategory = new HashSet<String>(0);

    /**
     * 岗位类型
     **/
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = true)
    private PositionType positionType;

    /**
     * 关注培训师
     **/
    @Column(length = 1000)
    private String attentionTrainer;

    /**
     * 公司发起的橄榄枝
     **/
    private String olives;

    /**
     * 汽车经验
     **/
    private Integer autoYears;

    /**
     * 是否认证
     **/
    private boolean authFaithed = false;

    /**
     * 培训经历
     **/
    @Column(length = 1000)
    private String trainingHistroy;

    /**
     * 工作经历
     **/
    @Column(length = 1000)
    private String workingHistroy;

    /**
     * 所获认证
     **/
    @Column(length = 1000)
    private String authHistroy;

    /**
     * 工作照片1
     **/
    @UiConfig(cssClass = "imagepick", viewTemplate = "<#if value?has_content><a href=\"<@url value=value/>\" target=\"_blank\"><img src=\"<@url value=value/>\" style=\"height:50px;\"/></a></#if>")
    private String workPhotoURL1;

    /**
     * 工作照片2
     **/
    @UiConfig(cssClass = "imagepick", viewTemplate = "<#if value?has_content><a href=\"<@url value=value/>\" target=\"_blank\"><img src=\"<@url value=value/>\" style=\"height:50px;\"/></a></#if>")
    private String workPhotoURL2;

    /**
     * 创建日期
     **/
    @UiConfig(hidden = true)
    @Column(updatable = false)
    private Date createDate = new Date();

    /**
     * 修改日期
     **/
    @NotInCopy
    @UiConfig(hidden = true)
    @Column(insertable = false)
    private Date modifyDate;

    /**
     * 创建用户
     **/
    @NotInCopy
    @UiConfig(hidden = true)
    @Column(updatable = false)
    private String createUser;

    /**
     * 修改用户
     **/
    @NotInCopy
    @UiConfig(hidden = true)
    @Column(insertable = false)
    private String modifyUser;

    /**
     * 是否推荐
     **/
    private boolean promoted = false;

    @Version(value = 0)
    @UiConfig(hidden = true)
    private int version = -1;


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

    public String getCurrentWorkStatus() {
        return currentWorkStatus;
    }

    public void setCurrentWorkStatus(String currentWorkStatus) {
        this.currentWorkStatus = currentWorkStatus;
    }

    public String getAttentionTrainer() {
        return attentionTrainer;
    }

    public void setAttentionTrainer(String attentionTrainer) {
        this.attentionTrainer = attentionTrainer;
    }

    public String getOlives() {
        return olives;
    }

    public void setOlives(String olives) {
        this.olives = olives;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
