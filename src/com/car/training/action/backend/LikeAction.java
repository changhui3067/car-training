package com.car.training.action.backend;

/**
 * Created by bill on 11/12/16.
 */

import com.car.training.action.SimpleJsonAction;
import com.car.training.enums.UserType;
import com.car.training.service.LikeService;
import com.car.training.vo.LoginVO;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@AutoConfig
public class LikeAction extends SimpleJsonAction {

    private int targetUserId;

    @Autowired
    private LikeService likeService;

    private HttpSession session;

    private LoginVO loginVO;

    @JsonConfig(root = "data")
    public String like() {
        if (likeService.like(targetUserId)) {
            return successJSON();
        } else {
            return errorJSON("");
        }
    }

    @JsonConfig(root = "data")
    public String unLike() {
        if (likeService.unLike(targetUserId)) {
            return successJSON();
        } else {
            return errorJSON("");
        }
    }

    @Before
    public String beforeAction() {
        HttpServletRequest request = ServletActionContext.getRequest();
        session = request.getSession();
        loginVO = (LoginVO) session.getAttribute("loginVO");
        if (loginVO !=null && loginVO.getUserType().equals(UserType.AUTOBOT)){
            return null;
        }else{
            setTargetUrl("/website/index");
            return REDIRECT;
        }
    }


    public int getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(int targetUserId) {
        this.targetUserId = targetUserId;
    }


}