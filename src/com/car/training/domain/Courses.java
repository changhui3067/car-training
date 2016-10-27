package com.car.training.domain;

import org.ironrhino.common.model.Region;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Courses implements Serializable {

    private static final long serialVersionUID = -2197633192945779031L;

    private String id;

    /**
     * 课程名称
     **/
    private String courseName;

    /**
     * 课程类型
     **/
    private Set<String> courseType;

    /**
     * 发布日期
     **/
    private Date publishDate;

    /**
     * 上课时间
     **/
    private String schoolTime;

    /**
     * 价格
     **/
    private BigDecimal price;

    /**
     * 时长
     **/
    private String longTime;

    /**
     * 区域
     **/
    private Region region;

    /**
     * 受众
     **/
    private String audiences;

    /**
     * 报名人数
     **/
    private Integer willnum;

    /**
     * 课程目标
     **/
    private String courseTarget;

    /**
     * 课程大纲
     **/
    private String courseOutline;

    /**
     * 课程大纲
     **/
    private String toolModel;

    /**
     * 培训师
     */
    private Trainer trainer;

    private Date createDate;

    private Date modifyDate;

    private String createUser;

    private String modifyUser;

    private boolean enabled;

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

    public Integer getWillnum() {
        return willnum;
    }

    public void setWillnum(Integer willnum) {
        this.willnum = willnum;
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

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
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

}
