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
@Table(name = "topic_comment")
public class TopicComment extends BaseEntity {

    private static final long serialVersionUID = 6163518563667489408L;

    @JoinColumn(name = "trainerId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Trainer trainer;

    @NotInCopy
    @JoinColumn(name = "topicId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;

    @Column(length = 2000, nullable = true)
    private String content;

    @Column(length = 1000, nullable = true)
    private String parentId;

    private Integer praiseCount;

    @UiConfig(hidden = true)
    @Column(updatable = false)
    private Date createDate = new Date();

    @NotInCopy
    @UiConfig(hidden = true)
    @Column(insertable = false)
    private Date modifyDate;


    @JsonIgnore
    private boolean enabled = true;

    @Version(value = 0)
    @UiConfig(hidden = true)
    private int version = -1;

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


}
