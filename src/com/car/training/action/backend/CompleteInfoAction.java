package com.car.training.action.backend;

import com.car.training.bean.*;
import com.car.training.enums.UserType;
import com.car.training.service.AutobotService;
import com.car.training.service.CompanyService;
import com.car.training.service.TrainerService;
import com.car.training.service.UserService;
import com.car.training.vo.LoginVO;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by freyjachang on 11/19/16.
 */
@AutoConfig
public class CompleteInfoAction extends BaseAction {
    @Autowired
    private UserService userService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private AutobotService autobotService;

    @Autowired
    private CompanyService companyService;

    private Trainer trainer;

    private Autobot autobot;

    private Company companyInfo;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        LoginVO loginVO  = (LoginVO) request.getSession().getAttribute("loginVO");
        LoginUser loginUser = userService.getUser(loginVO.getUsername());
        String pageName;
        switch(loginVO.getUserType()) {
            case TRAINER:
                trainer = trainerService.findByLoginUser(loginUser);
                pageName = "completeInfoTrainer";
                break;
            case AUTOBOT:
                autobot = autobotService.findByLoginUser(loginUser);
                pageName = "completeInfoAutobot";
                break;
            case COMPANY:
            case STORE:
                companyInfo = companyService.findByLoginUser(loginUser);
                pageName = "completeInfoCompany";
                break;
            default:
                return "";

        }
        return pageName;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Company getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(Company companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Autobot getAutobot() {
        return autobot;
    }

    public void setAutobot(Autobot autobot) {
        this.autobot = autobot;
    }
}
