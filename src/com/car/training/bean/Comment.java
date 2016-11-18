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
    private int userId;

    @Column
    private int targetUserId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(int targetUserId) {
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
