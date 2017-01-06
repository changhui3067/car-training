package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.bean.*;
import com.car.training.enums.UserType;
import com.car.training.service.CommentService;
import com.car.training.service.CompanyService;
import com.car.training.service.SimpleService;
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

/**
 * Created by bill on 11/7/16.
 */
@AutoConfig
public class UserCenterAction extends SimpleAction {

    private static final long serialVersionUID = 7654848347188004593L;


    @Autowired
    private SimpleService simpleService;

    @Autowired
    private SmsManager smsManager;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    private UserType userType;

    private String password;

    private String oldPassword;


    private String username;

    private String vercode;


    public static String defaultAvatar = "http://obu3flkwk.bkt.clouddn.com/car/training/upload/1480767851719.png";

    @JsonConfig(root = "data")
    public String login() {
        LoginUser user = userService.login(username, password);
        if (user == null) {
            return errorJSON("您的账号或密码错误！");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            LoginVO loginVO = new LoginVO();
            loginVO.setId(user.getId());
            loginVO.setUsername(user.getUsername());
            loginVO.setUserType(user.getType());
            loginVO.setLoggedIn(true);
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
        if (userService.existUser(username)) {
            return errorJSON("用户名已存在！");
        }
        if (!smsManager.checkCode(username, vercode)) {
            return errorJSON("验证码错误");
        }
        PersonInfo personInfo = null;
        LoginUser user;
        user = new LoginUser();

        switch (userType) {
            case TRAINER:
            case AUTOBOT:
                personInfo = new PersonInfo();
                personInfo.setMobile(username);
                personInfo.setAvatarUrl(defaultAvatar);
                break;
            case COMPANY:
            case STORE:
                break;
            default:
                return errorJSON("用户类型错误");
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setType(userType);
        switch (userType) {
            case TRAINER:
                Trainer trainer = new Trainer();
                trainer.setLoginUser(user);
                trainer.setPersonInfo(personInfo);
                simpleService.save(trainer);
                break;
            case AUTOBOT:
                Autobot autobot = new Autobot();
                autobot.setLoginUser(user);
                autobot.setPersonInfo(personInfo);
                simpleService.save(autobot);
                break;
            case COMPANY:
            case STORE:
                Company company = new Company();
                company.setLoginUser(user);
                company.setLogoUrl(defaultAvatar);
                companyService.save(company);
                break;
            default:
                return errorJSON("用户类型错误");
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        LoginVO loginVO = new LoginVO();
        loginVO.setId(user.getId());
        loginVO.setUsername(user.getUsername());
        loginVO.setUserType(user.getType());
        loginVO.setLoggedIn(true);
        session.setAttribute("loginVO", loginVO);
        return successJSON();
    }

    @JsonConfig(root = "data")
    public String resetPassword() {
        if(vercode!=null){
            if (!smsManager.checkCode(username, vercode)) {
                return errorJSON("验证码错误");
            }
            if (userService.updatePassword(username, password)) {
                return successJSON();
            } else {
                return errorJSON("用户不存在");
            }
        } else if (oldPassword !=null && isloggedIn()){
            if (userService.updatePassword(getLoginVO().getUsername(),oldPassword, password)) {
                return successJSON();
            } else {
                return errorJSON("密码错误或用户不存在");
            }
        }else{
            return errorJSON("传入错误的参数");
        }
    }

    @JsonConfig(root = "data")
    public String sendmsgForRegister() {
        if (userService.existUser(username)) {
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
        if (userService.existUser(username)) {
            return errorJSON("用户不存在");
        }
        try {
            smsManager.send(username, SmsTemplate.RESETPASSWORD);
            return successJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return errorJSON("发送验证码失败，请重试");
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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
