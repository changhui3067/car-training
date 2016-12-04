package com.car.training.action.backend;

/**
 * Created by bill on 11/12/16.
 */

import com.car.training.action.SimpleAction;
import com.car.training.bean.LoginUser;
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
public class LikeAction extends SimpleAction {

    private int targetUserId;

    @Autowired
    private LikeService likeService;

    @Autowired
    private LoginVO loginVO;

    @JsonConfig(root = "data")
    public String like() {
        if (likeService.like(loginVO.getId(),targetUserId)) {
            return successJSON();
        } else {
            return errorJSON("");
        }
    }

    @JsonConfig(root = "data")
    public String unLike() {
        if (likeService.unLike(loginVO.getId(),targetUserId)) {
            return successJSON();
        } else {
            return errorJSON("");
        }
    }

    @Before
    public String checkPermission() {
        LoginVO loginVO = getLoginVO();
        if (loginVO == null) {
            return errorJSON("请登录");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setId(targetUserId);
        if (loginVO.getUserType() == UserType.COMPANY || loginVO.getUserType() == UserType.STORE ||
                loginVO.getUserType() == loginUser.getType()) {
            return errorJSON("没有权限");
        }
        return null;
    }

    @Override
    protected boolean needLogin() {
        return true;
    }

    public int getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(int targetUserId) {
        this.targetUserId = targetUserId;
    }


}
