package com.car.training.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String userId;

    @Column
    private String targetUserId;

    @Column
    private String content;

    @Column
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
