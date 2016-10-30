package com.car.training.action.backend;

import com.car.training.domain.Autobots;
import com.car.training.domain.Company;
import com.car.training.domain.Trainer;
import com.car.training.domain.UserCenter;
import com.car.training.enums.UserType;
import com.car.training.exceptions.NotFoundException;
import com.car.training.service.AutobotsService;
import com.car.training.service.CompanyService;
import com.car.training.service.TrainerService;
import com.car.training.service.UserCenterService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.struts.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@AutoConfig
@Order(0)
public class LoginAction extends BaseAction {

    private static final long serialVersionUID = 7654848347188004593L;

    protected static Logger log = LoggerFactory.getLogger(LoginAction.class);

    protected UserType userType;

    protected String password;

    protected String username;
    @Autowired
    protected transient UserCenterService usercenterService;
    @Autowired
    protected transient CompanyService companyService;
    private String vercode;
    private Object data;
    private String captcha;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private AutobotsService autobotsService;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    @JsonConfig(root = "data")
    public String login() {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter usercenter = null;
        Company company = null;
        if (StringUtils.isBlank(username)) {
            throw new NotFoundException("1001", "用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            throw new NotFoundException("1002", "密码不能为空");
        }
        if (userType == null) {
            throw new NotFoundException("1004", "请选择用户类型");
        }
        if (userType.equals(UserType.PERSONAL)) {
            if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
                usercenter = usercenterService.findByUsernamePassword(username, password);
                if (usercenter != null) {
                    HttpSession context = request.getSession();
                    Autobots autobots = autobotsService.findByUserCenter(usercenter.getId());
                    if (autobots != null) {
                        usercenter.setAutobot(autobots);
                    }
                    Trainer trainer = trainerService.findByUserCenter(usercenter.getId());
                    if (trainer != null) {
                        usercenter.setTrainer(trainer);
                    }
                    context.setAttribute("userDetails", usercenter);
                    targetUrl = "/backend/applyJobHistory";
                    request.getSession().setAttribute("loginState", "Y");
                    request.getSession().setAttribute("loginType", usercenter.getPersonalType().name());
                    map.put("code", 200);
                    map.put("target", targetUrl);
                    map.put("msg", "登陆成功！");
                } else {
                    map.put("code", 400);
                    map.put("msg", "您的账号或密码错误！");
                }
            }
        } else if (userType.equals(UserType.COMPANY)) {
            if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
                company = companyService.findByUsernamePassword(username, password);
                if (company != null) {
                    HttpSession context = request.getSession();
                    context.setAttribute("userDetails", company);
                    targetUrl = "/backend/companyJobManage";
                    request.getSession().setAttribute("loginState", "Y");
                    request.getSession().setAttribute("loginType", company.getCompanyType().name());
                    map.put("code", 200);
                    map.put("target", targetUrl);
                    map.put("msg", "登陆成功！");
                } else {
                    map.put("code", 400);
                    map.put("msg", "您的账号或密码错误！");
                }
            }
        }
        setData(map);
        return JSON;
    }

    /**
     * 用户登出
     */
    @JsonConfig(root = "data")
    public String logout() {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("loginState", "N");
        map.put("code", 200);
        map.put("msg", "退出成功");
        setData(map);
        return JSON;
    }

    @Override
    public String execute() {
//		if (StringUtils.isBlank(targetUrl))
//			if (userType.equals(UserType.COMPANY)) {
//				targetUrl = "/website/backend/companyJobManger";
//			} else if (userType.equals(UserType.COMPANY)) {
//				targetUrl = "/website/backend/companyJobManger";
//			}
        return SUCCESS;
    }

}
