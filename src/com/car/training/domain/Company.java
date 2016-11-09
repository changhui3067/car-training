package com.car.training.domain;

import com.car.training.enums.CompanyType;
import com.car.training.enums.Industry;
import com.car.training.enums.Nature;
import com.car.training.enums.Scale;
import org.ironrhino.common.model.Region;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Company implements Serializable {

    private static final long serialVersionUID = -5028918733673342940L;

    private String id;

    /**
     * 公司名称
     **/
    private String name;

    /**
     * 账户名称
     **/
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 公司类别(公司/4S店)
     **/
    private CompanyType companyType;

    /**
     * 汽车品牌
     */
    private String autoBrand;

    /**
     * 区域
     **/
    private Region region;

    /**
     * 公司地址
     **/
    private String address;

    /**
     * 公司LOGO
     **/
    private String logo;

    /**
     * 公司规模
     **/
    private Scale scale;

    /**
     * 所属行业
     **/
    private Industry industry;

    /**
     * 公司性质
     **/
    private Nature nature;

    /**
     * 福利
     **/
    private Set<String> welfare;

    /**
     * 担保人
     **/
    private String bondsman;
    /**
     * 担保人数
     **/
    private int bondsmanCount;

    /**
     * 财富值
     */
    private BigDecimal wealth;

    /**
     * 财富值开始有效日期
     */
    private Date wealthStartDate;

    /**
     * 财富值结束有效日期
     */
    private Date wealthEndDate;

    /**
     * 公司介绍
     */
    private String intro;

    /**
     * 工作环境照片1
     **/
    private String environmentURL1;

    /**
     * 工作环境照片2
     **/
    private String environmentURL2;

    private Date createDate;

    private Date modifyDate;

    private String createUser;

    private String modifyUser;

    private boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getAutoBrand() {
        return autoBrand;
    }

    public void setAutoBrand(String autoBrand) {
        this.autoBrand = autoBrand;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public Set<String> getWelfare() {
        return welfare;
    }

    public void setWelfare(Set<String> welfare) {
        this.welfare = welfare;
    }

    public String getBondsman() {
        return bondsman;
    }

    public void setBondsman(String bondsman) {
        this.bondsman = bondsman;
    }

    public int getBondsmanCount() {
        return bondsmanCount;
    }

    public void setBondsmanCount(int bondsmanCount) {
        this.bondsmanCount = bondsmanCount;
    }

    public BigDecimal getWealth() {
        return wealth;
    }

    public void setWealth(BigDecimal wealth) {
        this.wealth = wealth;
    }

    public Date getWealthStartDate() {
        return wealthStartDate;
    }

    public void setWealthStartDate(Date wealthStartDate) {
        this.wealthStartDate = wealthStartDate;
    }

    public Date getWealthEndDate() {
        return wealthEndDate;
    }

    public void setWealthEndDate(Date wealthEndDate) {
        this.wealthEndDate = wealthEndDate;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getEnvironmentURL1() {
        return environmentURL1;
    }

    public void setEnvironmentURL1(String environmentURL1) {
        this.environmentURL1 = environmentURL1;
    }

    public String getEnvironmentURL2() {
        return environmentURL2;
    }

    public void setEnvironmentURL2(String environmentURL2) {
        this.environmentURL2 = environmentURL2;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
