package com.car.training.domain;

import com.car.training.enums.Gender;
import com.car.training.enums.MarryStatus;
import com.car.training.enums.PersonalType;
import org.ironrhino.common.model.Region;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserCenter implements Serializable {

    private static final long serialVersionUID = 3866152838567659638L;

    /**
     * 系统Id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名r
     **/
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 头像
     */
    private String headLogo;

    /**
     * 性别
     */
    private Gender gender;

    /**
     * 婚姻状态
     */
    private MarryStatus marryStatus;

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
     * 身份证号
     */
    private String idCard;

    /**
     * QQ
     */
    private String QQ;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮件
     */
    private String email;

    /**
     * 微信号
     */
    private String weixin;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 简介
     */
    private String intro;

    /**
     * 个人类型
     */
    private PersonalType personalType;

    /**
     * 区域
     */
    private Region region;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 活跃日期
     */
    private Date activeDate;

    /**
     * 修改日期
     */
    private Date modifyDate;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 是否启用
     */
    private boolean enabled;

    private Autobots autobot;

    private Trainer trainer;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHeadLogo() {
        return headLogo;
    }

    public void setHeadLogo(String headLogo) {
        this.headLogo = headLogo;
    }

    public MarryStatus getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(MarryStatus marryStatus) {
        this.marryStatus = marryStatus;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String qQ) {
        QQ = qQ;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public PersonalType getPersonalType() {
        return personalType;
    }

    public void setPersonalType(PersonalType personalType) {
        this.personalType = personalType;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
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

    public Autobots getAutobot() {
        return autobot;
    }

    public void setAutobot(Autobots autobot) {
        this.autobot = autobot;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }


}
