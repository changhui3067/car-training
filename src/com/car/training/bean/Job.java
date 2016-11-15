package com.car.training.bean;

import com.car.training.enums.JobType;
import com.car.training.enums.UserType;
import org.ironrhino.common.model.Region;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bill on 11/1/2016.
 */
@Entity
@Table
public class Job {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private String title;

    @Column
    private int publishCompanyId;

    @Column
    private int workExperienceRequirement;

    @JoinColumn(name = "regionId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne()
    private Region region;

    @Column
    private String educationRequirement;

    @Column
    private String salary;

    @Column
    private String jobDescription;

    @Column
    private Date createDate;

    @Column
    private String majorRequirement;

    @Column
    private String LanguageRequirement;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private JobType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishCompanyId() {
        return publishCompanyId;
    }

    public void setPublishCompanyId(int publishCompanyId) {
        this.publishCompanyId = publishCompanyId;
    }

    public int getWorkExperienceRequirement() {
        return workExperienceRequirement;
    }

    public void setWorkExperienceRequirement(int workExperienceRequirement) {
        this.workExperienceRequirement = workExperienceRequirement;
    }



    public String getEducationRequirement() {
        return educationRequirement;
    }

    public void setEducationRequirement(String educationRequirement) {
        this.educationRequirement = educationRequirement;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateTime(Date createTime) {
        this.createDate = createTime;
    }

    public String getMajorRequirement() {
        return majorRequirement;
    }

    public void setMajorRequirement(String majorRequirement) {
        this.majorRequirement = majorRequirement;
    }

    public String getLanguageRequirement() {
        return LanguageRequirement;
    }

    public void setLanguageRequirement(String languageRequirement) {
        LanguageRequirement = languageRequirement;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
