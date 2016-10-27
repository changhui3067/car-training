package com.car.training.action.website;

import com.car.training.domain.Company;
import com.car.training.domain.UserCenter;
import com.car.training.enums.CompanyType;
import com.car.training.enums.PersonalType;
import com.car.training.enums.UserType;
import com.car.training.exceptions.AppException;
import com.car.training.service.CompanyService;
import com.car.training.service.UserCenterService;
import com.car.training.sms.SmsService;
import com.car.training.sms.SmsTemplate;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;


@AutoConfig
public class RegisterAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private UserCenterService usercenterService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private SmsService smsService;
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户确认密码
     */
    private String comfirmPassword;

    /**
     * 个人类型-培训师、汽车人
     */
    private PersonalType personalType;

    /**
     * 公司类型-培训公司、汽车公司
     */
    private CompanyType companyType;

    /**
     * 用户类型-公司、个人
     */
    private UserType userType;

    private String verCode;

    @Override
    public String execute() throws Exception {
        if (userType == null) {
            throw new AppException("用户类型不能为空");
        } else {
            if (userType.equals(UserType.PERSONAL)) {
                if (personalType == null) {
                    throw new AppException("个人类型不能为空");
                }
            } else if (userType.equals(UserType.COMPANY)) {
                if (companyType == null) {
                    throw new AppException("企业类型不能为空");
                }
            }
        }
        if (StringUtils.isBlank(username)) {
            throw new AppException("请输入手机号/邮箱");
        }
        if (StringUtils.isBlank(password)) {
            throw new AppException("密码不能为空");
        }
        if (StringUtils.isBlank(comfirmPassword)) {
            throw new AppException("确认密码不能为空");
        }
        if (StringUtils.isBlank(verCode)) {
            throw new AppException("手机验证码不能为空");
        }
        if (userType.equals(UserType.PERSONAL)) {
            UserCenter uc = new UserCenter();
            uc.setUsername(username);
            uc.setPassword(comfirmPassword);
            uc.setPersonalType(personalType);
            usercenterService.save(uc);
        } else if (userType.equals(UserType.COMPANY)) {
            Company company = new Company();
            company.setUsername(username);
            company.setPassword(comfirmPassword);
            company.setCompanyType(companyType);
            companyService.save(company);
        }
        return SUCCESS;
    }

    /**
     * 发送短信验证码到手机
     *
     * @return
     * @throws Exception
     */
    public String sendMessage() throws Exception {
        if (StringUtils.isBlank(username)) {
            throw new AppException("请输入手机号");
        }
        smsService.send(username, SmsTemplate.REGISTER.name());
        return SUCCESS;
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

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }

    public PersonalType getPersonalType() {
        return personalType;
    }

    public void setPersonalType(PersonalType personalType) {
        this.personalType = personalType;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }
}
