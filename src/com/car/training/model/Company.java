package com.car.training.model;

import com.car.training.enums.old.CompanyType;
import com.car.training.enums.old.Industry;
import com.car.training.enums.old.Nature;
import com.car.training.enums.old.Scale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.ironrhino.common.model.Region;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.Hidden;
import org.ironrhino.core.metadata.NotInCopy;
import org.ironrhino.core.metadata.UiConfig;
import org.ironrhino.core.model.BaseEntity;
import org.ironrhino.core.search.elasticsearch.annotations.Searchable;
import org.ironrhino.core.util.AuthzUtils;
import org.nustaq.serialization.annotations.Version;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Searchable
//@AutoConfig
//@javax.persistence.Entity
//@Table(name = "company")
public class Company extends BaseEntity implements UserDetails {

    private static final long serialVersionUID = -5484521796779236186L;

    /**
     * 公司名称
     **/
    @Column(length = 50, nullable = true)
    private String name;

    /**
     * 账户名称
     **/
    @Column(length = 50, nullable = false)
    private String username;

    /**
     * 密码
     */
    @Column(length = 50, nullable = true)
    private String password;

    /**
     * 公司类别(公司/4S店)
     **/
    @UiConfig(hiddenInList = @Hidden(true))
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CompanyType companyType;

    /**
     * 汽车品牌
     */
    private String autoBrand;

    /**
     * 区域
     **/
    @JoinColumn(name = "regionId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Region region;

    /**
     * 公司地址
     **/
    @Column(length = 100, nullable = true)
    private String address;

    /**
     * 公司LOGO
     **/
    @Column(length = 255, nullable = true)
    @UiConfig(cssClass = "imagepick", viewTemplate = "<#if value?has_content><a href=\"<@url value=value/>\" target=\"_blank\"><img src=\"<@url value=value/>\" style=\"height:50px;\"/></a></#if>")
    private String logo;

    /**
     * 公司规模
     **/
    @UiConfig(hiddenInList = @Hidden(true))
    private Scale scale;

    /**
     * 所属行业
     **/
    @UiConfig(hiddenInList = @Hidden(true))
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = true)
    private Industry industry = Industry.AUTO;

    /**
     * 公司性质
     **/
    @UiConfig(hiddenInList = @Hidden(true))
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = true)
    private Nature nature = Nature.PERSONAL;

    /**
     * 福利
     **/
    @UiConfig(hiddenInList = @Hidden(true))
    private Set<String> welfare = new HashSet<String>(0);

    /**
     * 担保人
     **/
    @Column(length = 1000, nullable = true)
    private String bondsman;

    /**
     * 财富值
     */
    private BigDecimal wealth;

    /**
     * 财富值开始有效日期
     */
    @Temporal(TemporalType.DATE)
    private Date wealthStartDate;

    /**
     * 财富值结束有效日期
     */
    @Temporal(TemporalType.DATE)
    private Date wealthEndDate;

    /**
     * 公司简介
     */
    @Column(length = 4000, nullable = true)
    private String intro;

    /**
     * 工作环境照片1
     **/
    @UiConfig(cssClass = "imagepick", viewTemplate = "<#if value?has_content><a href=\"<@url value=value/>\" target=\"_blank\"><img src=\"<@url value=value/>\" style=\"height:50px;\"/></a></#if>")
    private String environmentURL1;

    /**
     * 工作环境照片2
     **/
    @UiConfig(cssClass = "imagepick", viewTemplate = "<#if value?has_content><a href=\"<@url value=value/>\" target=\"_blank\"><img src=\"<@url value=value/>\" style=\"height:50px;\"/></a></#if>")
    private String environmentURL2;

    /**
     * 创建日期
     */
    @UiConfig(hidden = true)
    @Column(updatable = false)
    private Date createDate = new Date();

    /**
     * 修改日期
     */
    @NotInCopy
    @UiConfig(hidden = true)
    @Column(insertable = false)
    private Date modifyDate;

    /**
     * 创建人
     */
    @NotInCopy
    @UiConfig(hidden = true)
    @Column(updatable = false)
    private String createUser;

    /**
     * 修改人
     */
    @NotInCopy
    @UiConfig(hidden = true)
    @Column(insertable = false)
    private String modifyUser;

    /**
     * 是否启用
     */
    @JsonIgnore
    private boolean enabled = true;

    @Version(value = 0)
    @UiConfig(hidden = true)
    private int version = -1;

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

    public void setLegiblePassword(String legiblePassword) {
        this.password = AuthzUtils.encodePassword(this, legiblePassword);
    }

    public boolean isPasswordValid(String legiblePassword) {
        return AuthzUtils.encodePassword(this, legiblePassword).equals(this.password);
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
}
