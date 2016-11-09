package com.car.training.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table
public class Article {

    @Id
    @GeneratedValue
    @Column
    private String id;

    /**
     * 发布者
     */
    @Column
    private int traineruid;

    /**
     * 文章标题
     */
    @Column
    private String title;

    /**
     * 文章内容
     */
    @Column
    private String content;



    /**
     * 创建日期
     */
    @Column
    private Date createDate;

    /**
     * 最近编辑日期
     */
    @Column
    private Date lastModifiedData;


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

    public Date getLastModifiedData() {
        return lastModifiedData;
    }

    public void setLastModifiedData(Date lastModifiedData) {
        this.lastModifiedData = lastModifiedData;
    }

    public int getTraineruid() {
        return traineruid;
    }

    public void setTraineruid(int traineruid) {
        this.traineruid = traineruid;
    }
}
