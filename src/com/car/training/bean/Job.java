package com.car.training.bean;

import javax.persistence.*;

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

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
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

    @Column
    private int workExperienceRequirement;


    @Column
    private String regionId;

    @Column
    private String educationRequirement;

    @Column
    private String salary;

    @Column
    private String jobDescription;




}
