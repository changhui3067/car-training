package com.car.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.Hidden;
import org.ironrhino.core.metadata.NotInCopy;
import org.ironrhino.core.metadata.UiConfig;
import org.ironrhino.core.model.BaseEntity;
import org.nustaq.serialization.annotations.Version;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Searchable
//@AutoConfig
//@javax.persistence.Entity
//@Table(name = "courses")
public class Courses extends BaseEntity {

    private static final long serialVersionUID = -5621639682381355149L;

    /**
     * 课程名称
     **/
    @Column(length = 100, nullable = true)
    private String courseName;

    /**
     * 课程类型
     **/
    private Set<String> courseType = new HashSet<String>(0);

    /**
     * 发布日期
     **/
    private Date publishDate = new Date();

    /**
     * 上课时间
     **/
    @Column(length = 50, nullable = true)
    private String schoolTime;

    /**
     * 价格
     **/
    @UiConfig(hiddenInList = @Hidden(true))
    private BigDecimal price;

    /**
     * 时长
     **/
    @UiConfig(hiddenInList = @Hidden(true))
    private String longTime;

    /**
     * 区域
     **/
    @JoinColumn(name = "regionId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Region region;

    /**
     * 受众
     **/
    private String audiences;

    /**
     * 课程目标
     **/
    private String courseTarget;

    /**
     * 课程大纲
     **/
    private String courseOutline;

    /**
     * 工具模型
     **/
    private String toolModel;

    /**
     * 培训师
     */
    @JoinColumn(name = "trainerId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OldTrainer oldTrainer;

    @UiConfig(hidden = true)
    @Column(updatable = false)
    private Date createDate = new Date();

    @NotInCopy
    @UiConfig(hidden = true)
    @Column(insertable = false)
    private Date modifyDate;

    @NotInCopy
    @UiConfig(hidden = true)
    @Column(updatable = false)
    private String createUser;

    @NotInCopy
    @UiConfig(hidden = true)
    @Column(insertable = false)
    private String modifyUser;

    @JsonIgnore
    private boolean enabled = true;

    /**
     * 是否推荐
     **/
    private boolean promoted = false;

    @Version(value = 0)
    @UiConfig(hidden = true)
    private int version = 0;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<String> getCourseType() {
        return courseType;
    }

    public void setCourseType(Set<String> courseType) {
        this.courseType = courseType;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(String schoolTime) {
        this.schoolTime = schoolTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLongTime() {
        return longTime;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getAudiences() {
        return audiences;
    }

    public void setAudiences(String audiences) {
        this.audiences = audiences;
    }

    public String getCourseTarget() {
        return courseTarget;
    }

    public void setCourseTarget(String courseTarget) {
        this.courseTarget = courseTarget;
    }

    public String getCourseOutline() {
        return courseOutline;
    }

    public void setCourseOutline(String courseOutline) {
        this.courseOutline = courseOutline;
    }

    public String getToolModel() {
        return toolModel;
    }

    public void setToolModel(String toolModel) {
        this.toolModel = toolModel;
    }

    public OldTrainer getOldTrainer() {
        return oldTrainer;
    }

    public void setOldTrainer(OldTrainer oldTrainer) {
        this.oldTrainer = oldTrainer;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
