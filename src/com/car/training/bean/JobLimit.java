package com.car.training.bean;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by bill on 11/30/16.
 */
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"companyId"} ))
@Entity
public class JobLimit {
    
    @Id
    @GeneratedValue
    @Column
    private int id;
    
    @Column
    private int companyId;
    
    @Column
    private int maxPublishJobCount;
    
    @Column
    private int currentPublishJobCount;
    
    @Column
    private Date vipExpireDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getMaxPublishJobCount() {
        return maxPublishJobCount;
    }

    public void setMaxPublishJobCount(int maxPublishJobCount) {
        this.maxPublishJobCount = maxPublishJobCount;
    }

    public int getCurrentPublishJobCount() {
        return currentPublishJobCount;
    }

    public void setCurrentPublishJobCount(int currentPublishJobCount) {
        this.currentPublishJobCount = currentPublishJobCount;
    }

    public Date getVipExpireDate() {
        return vipExpireDate;
    }

    public void setVipExpireDate(Date vipExpireDate) {
        this.vipExpireDate = vipExpireDate;
    }
}
