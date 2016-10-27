package com.car.training.domain;

import java.io.Serializable;
import java.util.Date;

public class Topic implements Serializable {

    private static final long serialVersionUID = -8497314371362637326L;

    private String id;

    /**
     * 专题标题
     **/
    private String title;

    /**
     * 专题标识图片
     **/
    private String topicLogo;

    /**
     * 专题内容
     **/
    private String content;

    /**
     * 发布日期
     **/
    private Date publishDate;

    /**
     * 标签，关健字
     **/
    private String keyword;

    /**
     * 点击数
     **/
    private int hitCount;

    private Date createDate;

    private Date modifyDate;

    private String createUser;

    private String modifyUser;

    private boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicLogo() {
        return topicLogo;
    }

    public void setTopicLogo(String topicLogo) {
        this.topicLogo = topicLogo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
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
}
