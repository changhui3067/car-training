package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.enums.UserType;
import com.car.training.service.JobApplyService;
import com.car.training.vo.LoginVO;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bill on 11/19/2016.
 */
@AutoConfig
public class JobApplyAction extends SimpleAction {

    @Autowired
    JobApplyService jobApplyService;

    private int jobId;

    @JsonConfig(root = "data")
    public String execute(){
        try{
            jobApplyService.apply(jobId,getLoginVO());
        }catch (Exception ignored){
            return errorJSON("error when saving");
        }
        return successJSON();
    }

    @Before
    public String checkPermission() {
        LoginVO loginVO = getLoginVO();
        if (loginVO == null) {
            return errorJSON("请登录");
        }
        if (loginVO.getUserType() == UserType.COMPANY || loginVO.getUserType() == UserType.STORE) {
            return errorJSON("没有权限");
        }
        return null;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
