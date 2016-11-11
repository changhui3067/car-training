package com.car.training.action.backend;

import com.car.training.action.SimpleJsonAction;
import com.car.training.bean.*;
import com.car.training.dao.BaseDAO;
import com.car.training.enums.UserType;
import com.car.training.service.UserService;
import com.car.training.sms.SmsManager;
import com.car.training.sms.SmsTemplate;
import com.car.training.vo.LoginVO;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bill on 11/7/16.
 */
@AutoConfig
public class UserCenterAction extends SimpleJsonAction {

    private static final long serialVersionUID = 7654848347188004593L;


    @Autowired
    private BaseDAO baseDAO;

    @Autowired
    private SmsManager smsManager;

    private UserType userType;

    private String personOrCompany;

    private String password;

    private String username;

    private String vercode;

    @Autowired
    private UserService userService;


    @JsonConfig(root = "data")
    public String login() {
        //TODO sync with frondend the paramater
        LoginBean user = userService.login(username, "PERSON".equals(personOrCompany), password);
        if (user == null) {
            return errorJSON("您的账号或密码错误！");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            LoginVO loginVO = new LoginVO(user.getId(), user.getUsername(), user.getType());
            session.setAttribute("loginVO", loginVO);
            return successJSON();
        }
    }

    /**
     * 用户登出
     */
    public String logout() {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("loginVO", null);
        return redirectToIndex();
    }


    @JsonConfig(root = "data")
    public String register() {
        Map<String, Object> map = new HashMap<>();
        if (userService.existUser(username, userType)) {
            return errorJSON("用户名已存在！");
        }
        if (!smsManager.checkCode(username, vercode)) {
            return errorJSON("wrong verification code");
        }
        PersonInfo personInfo = null;
        LoginBean user;
        switch (userType) {
            case TRAINER:
            case AUTOBOT:
                user = new LoginUser();
                personInfo = new PersonInfo();
                personInfo.setMobile(username);
                break;
            case COMPANY:
            case STORE:
                user = new LoginCompany();
                break;
            default:
                return errorJSON("wrong user type");
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setType(userType);
        switch (userType) {
            case TRAINER:
                Trainer trainer = new Trainer();
                trainer.setLoginUser((LoginUser) user);
                trainer.setPersonInfo(personInfo);
                baseDAO.save(trainer);
                break;
            case AUTOBOT:
                Autobot autobot = new Autobot();
                autobot.setLoginUser((LoginUser) user);
                autobot.setPersonInfo(personInfo);
                baseDAO.save(autobot);
                break;
            case COMPANY:
            case STORE:
                Company company = new Company();
                company.setLoginCompany((LoginCompany) user);
                baseDAO.save(company);
                break;
            default:
                return errorJSON("wrong user type");
        }
        return successJSON();
    }

    @JsonConfig(root = "data")
    public String resetPassword() {
        if (!smsManager.checkCode(username, vercode)) {
            return errorJSON("wrong verification code");
        }
        if (userService.updatePassword(username, userType, password)) {
            return successJSON();
        } else {
            return errorJSON("user not exist");
        }

    }

    @JsonConfig(root = "data")
    public String sendmsgForRegister() {
        if (userService.existUser(username, userType)) {
            return errorJSON("手机账号已注册！");
        }
        try {
            smsManager.send(username, SmsTemplate.REGISTER);
            return successJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return successJSON();
    }

    @JsonConfig(root = "data")
    public String sendmsgForResetPassword() {
        if (userService.existUser(username, userType)) {
            return errorJSON("user not exist");
        }
        try {
            smsManager.send(username, SmsTemplate.RESETPASSWORD);
            return successJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return errorJSON("fail to send message, please try again");
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public void setUserType(String userType) {
        this.userType = UserType.valueOf(userType);
    }

    public String getPersonOrCompany() {
        return personOrCompany;
    }

    public void setPersonOrCompany(String personOrCompany) {
        this.personOrCompany = personOrCompany;
    }
}
