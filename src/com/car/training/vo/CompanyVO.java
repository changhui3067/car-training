package com.car.training.vo;

/**
 * Created by bill on 11/30/16.
 */
public class CompanyVO {
    private int id;
    private String name;
    private String industry;
    private String welfare;
    private String logoUrl;
    private int guaranteeNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public int getGuaranteeNumber() {
        return guaranteeNumber;
    }

    public void setGuaranteeNumber(int guaranteeNumber) {
        this.guaranteeNumber = guaranteeNumber;
    }
}
