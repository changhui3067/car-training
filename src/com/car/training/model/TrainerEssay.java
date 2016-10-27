package com.car.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.NotInCopy;
import org.ironrhino.core.metadata.UiConfig;
import org.ironrhino.core.model.BaseEntity;
import org.ironrhino.core.search.elasticsearch.annotations.Searchable;
import org.nustaq.serialization.annotations.Version;

import javax.persistence.*;
import java.util.Date;

@Searchable
@AutoConfig
@javax.persistence.Entity
@Table(name = "trainer_essay")
public class TrainerEssay extends BaseEntity {

    private static final long serialVersionUID = 4092941816602786998L;

    /**
     * 培训师
     */
    @JoinColumn(name = "trainerId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Trainer trainer;

    /**
     * 文章标题
     */
    @Column(length = 255)
    private String title;

    /**
     * 文章内容
     */
    @Column(length = 5000, nullable = true)
    private String content;

    /**
     * 发布日期
     */
    private Date publishDate;

    /**
     * 点赞数
     */
    private Integer praiseCount;

    /**
     * 创建日期
     */
    @UiConfig(hidden = true)
    @Column(updatable = false)
    private Date createDate = new Date();

    /**
     * 修改日期
     */
    @NotInCopy
    @UiConfig(hidden = true)
    @Column(insertable = false)
    private Date modifyDate;

    /**
     * 是否启用
     */
    @JsonIgnore
    private boolean enabled = true;

    /**
     * 是否推荐
     **/
    private boolean promoted = false;

    @Version(value = 0)
    @UiConfig(hidden = true)
    private int version = -1;

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
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
