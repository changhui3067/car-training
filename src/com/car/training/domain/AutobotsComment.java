package com.car.training.domain;

import java.io.Serializable;
import java.util.Date;

public class AutobotsComment implements Serializable {

    private static final long serialVersionUID = -8330767379598052647L;

    /**
     * 系统Id
     **/
    private String id;

    /**
     * 内容设计评分
     */
    private Integer contentDesignScore;

    /**
     * 课堂气氛评分
     */
    private Integer lessonAtmosphereScore;

    /**
     * 课后收获评分
     */
    private Integer afterLessonGainsScore;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 是否启用
     */
    private boolean enabled;

    private Autobots autobots;

    private Trainer trainer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getContentDesignScore() {
        return contentDesignScore;
    }

    public void setContentDesignScore(Integer contentDesignScore) {
        this.contentDesignScore = contentDesignScore;
    }

    public Integer getLessonAtmosphereScore() {
        return lessonAtmosphereScore;
    }

    public void setLessonAtmosphereScore(Integer lessonAtmosphereScore) {
        this.lessonAtmosphereScore = lessonAtmosphereScore;
    }

    public Integer getAfterLessonGainsScore() {
        return afterLessonGainsScore;
    }

    public void setAfterLessonGainsScore(Integer afterLessonGainsScore) {
        this.afterLessonGainsScore = afterLessonGainsScore;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Autobots getAutobots() {
        return autobots;
    }

    public void setAutobots(Autobots autobots) {
        this.autobots = autobots;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

}
