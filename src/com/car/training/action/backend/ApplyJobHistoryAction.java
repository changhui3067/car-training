package com.car.training.action.backend;

import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;

/**
 * Created by freyjachang on 11/19/16.
 */
@AutoConfig
public class ApplyJobHistoryAction extends BaseAction {

    @Override
    public String execute() throws Exception {

        return "applyJobHistory";
    }
}
