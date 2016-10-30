package com.car.training.action.backend;

import com.car.training.domain.Company;
import com.car.training.domain.UserCenter;
import com.car.training.enums.CompanyType;
import com.car.training.enums.PersonalType;
import com.car.training.enums.UserType;
import com.car.training.service.CompanyService;
import com.car.training.service.UserCenterService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.struts.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@AutoConfig
public class ModifyPasswordAction extends BaseAction {

    private static final long serialVersionUID = 7654848347188004593L;

    protected static Logger log = LoggerFactory.getLogger(ModifyPasswordAction.class);

    protected UserType userType;

    protected String oldpasswd;

    protected String newpasswd;

    protected String username;
    @Autowired
    protected transient UserCenterService usercenterService;
    @Autowired
    protected transient CompanyService companyService;
    private Object data;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getOldpasswd() {
        return oldpasswd;
    }

    public void setOldpasswd(String oldpasswd) {
        this.oldpasswd = oldpasswd;
    }

    public String getNewpasswd() {
        return newpasswd;
    }

    public void setNewpasswd(String newpasswd) {
        this.newpasswd = newpasswd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonConfig(root = "data")
    public String modify() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter usercenter = null;
        Company company = null;

        if (userType.equals(PersonalType.AUTOBOT) || userType.equals(PersonalType.TRAINER)) {
            if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(oldpasswd)) {
                usercenter = usercenterService.findByUsernamePassword(username, oldpasswd);
                if (usercenter != null) {
                    targetUrl = "/website/index/logout";
                    usercenterService.changePassword(username, oldpasswd, newpasswd);
                    map.put("code", 200);
                    map.put("target", targetUrl);
                    map.put("msg", "密码修改成功！");
                } else {
                    map.put("code", 400);
                    map.put("msg", "您的账号或密码错误！");
                }
            }
        } else if (userType.equals(CompanyType.COMPANY) || userType.equals(CompanyType.STORE)) {
            if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(oldpasswd)) {
                company = companyService.findByUsernamePassword(username, oldpasswd);
                if (company != null) {
                    HttpSession context = request.getSession();
                    context.setAttribute("userDetails", company);
                    targetUrl = "/website/index/logout";
                    company.setPassword(newpasswd);
                    companyService.changePassword(username, oldpasswd, newpasswd);
                    map.put("code", 200);
                    map.put("target", targetUrl);
                    map.put("msg", "密码修改成功！");
                } else {
                    map.put("code", 400);
                    map.put("msg", "您的账号或密码错误！");
                }
            }
        }
        setData(map);
        return JSON;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

}
