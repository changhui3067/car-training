package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Apply;
import com.car.training.bean.Job;
import com.car.training.bean.PersonInfo;
import com.car.training.bean.Trainer;
import com.car.training.service.JobApplyService;
import com.car.training.service.JobService;
import com.car.training.vo.LoginVO;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;

/**
 * Created by freyjachang on 11/19/16.
 */
@AutoConfig
public class PublishJobHistoryAction extends SimpleAction {
    @Autowired
    private JobService jobService;

    @Autowired
    private JobApplyService jobApplyService;

    private List<Job> jobList;

    private HashMap<Object, List<Apply>> jobApplyMap = new HashMap<>();

    @Override
    public String execute() throws Exception {
        Object loginVO = getLoginVO();
        if(loginVO != null) {
            jobList = jobService.findJobsByTargetCompany();
            generateJobApplyMap();
        }

        return "publishJobHistory";
    }

    public String add() throws Exception {
        return null;
    }

    private void generateJobApplyMap() {
        for(Job job : jobList) {
            List<Apply> applyList = jobApplyService.getApplyListByJob(job);
            jobApplyMap.put(job, applyList);
        }
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public HashMap<Object, List<Apply>> getJobApplyMap() {
        return jobApplyMap;
    }

    public void setJobApplyMap(HashMap<Object, List<Apply>> jobApplyMap) {
        this.jobApplyMap = jobApplyMap;
    }
}
