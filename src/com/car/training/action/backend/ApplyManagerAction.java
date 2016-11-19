package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.enums.UserType;
import com.car.training.vo.LoginVO;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;

/**
 * Created by Bill on 11/19/2016.
 */
@AutoConfig
public class ApplyManagerAction extends SimpleAction {

    @JsonConfig(root = "data")
    public String applyJob(){
        return successJSON();
    }

    @Before
    private String checkPermission() {
        LoginVO loginVO = getLoginVO();
        if (loginVO == null) {
            return errorJSON("not logged in");
        }
        if (loginVO.getUserType() == UserType.COMPANY || loginVO.getUserType() == UserType.STORE) {
            return errorJSON("not permitted");
        }
        return null;
    }
}
