package com.car.training.vo;

import com.car.training.bean.Company;
import org.ironrhino.common.model.Region;

/**
 * Created by bill on 11/30/16.
 */
public class JobVO {
    private String title;
    private String salary;
    private int workExperienceRequirement;
    private Region region;
    private CompanyVO company;
    private String createDate;
    private int id;


    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWorkExperienceRequirement() {
        return workExperienceRequirement;
    }

    public void setWorkExperienceRequirement(int workExperienceRequirement) {
        this.workExperienceRequirement = workExperienceRequirement;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public CompanyVO getCompany() {
        return company;
    }

    public void setCompany(CompanyVO company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
