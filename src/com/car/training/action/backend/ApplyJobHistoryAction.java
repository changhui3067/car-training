package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.service.JobService;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by freyjachang on 11/19/16.
 */
@AutoConfig
public class ApplyJobHistoryAction extends SimpleAction {

    @Autowired
    JobService jobService;

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    @Override
    protected boolean needLogin(){
        return true;
    }
}
