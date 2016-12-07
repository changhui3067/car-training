package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Apply;
import com.car.training.service.JobApplyService;
import com.car.training.service.JobService;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by freyjachang on 11/19/16.
 */
@AutoConfig
public class ApplyJobHistoryAction extends SimpleAction {

    @Autowired
    JobService jobService;

    @Autowired
    JobApplyService jobApplyService;

    private List<Apply> applyList;

    @Override
    public String execute() throws Exception {
        applyList = jobApplyService.getApplyListByUser(getLoginVO().getId());
        return "applyJobHistory";
    }

    @Override
    protected boolean needLogin(){
        return true;
    }

    public List<Apply> getApplyList() {
        return applyList;
    }

    public void setApplyList(List<Apply> applyList) {
        this.applyList = applyList;
    }
}
