package com.car.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.Hidden;
import org.ironrhino.core.metadata.NotInCopy;
import org.ironrhino.core.metadata.UiConfig;
import org.ironrhino.core.model.BaseEntity;
import org.ironrhino.core.search.elasticsearch.annotations.Searchable;
import org.nustaq.serialization.annotations.Version;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Searchable
@AutoConfig
@javax.persistence.Entity
@Table(name = "topic")
public class Topic extends BaseEntity {

    private static final long serialVersionUID = -4550736635312637032L;

    /**
     * 专题标题
     **/
    @Column(length = 100, nullable = true)
    private String title;

    /**
     * 专题标识图片
     **/
    @Column(length = 255, nullable = true)
    @UiConfig(cssClass = "imagepick", viewTemplate = "<#if value?has_content><a href=\"<@url value=value/>\" target=\"_blank\"><img src=\"<@url value=value/>\" style=\"height:50px;\"/></a></#if>")
    private String topicLogo;

    /**
     * 专题内容
     **/
    @Column(length = 2000, nullable = true)
    private String content;

    /**
     * 发布日期
     **/
    private Date publishDate = new Date();

    /**
     * 关健字
     **/
    @UiConfig(hiddenInList = @Hidden(true))
    private String keyword;

    /**
     * 点击数
     **/
    @UiConfig(hiddenInList = @Hidden(true))
    private int hitCount;

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

    @Version(value = 0)
    @UiConfig(hidden = true)
    private int version = -1;

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
