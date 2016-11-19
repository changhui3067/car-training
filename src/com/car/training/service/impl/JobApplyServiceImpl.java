package com.car.training.service.impl;

import com.car.training.bean.Apply;
import com.car.training.bean.Job;
import com.car.training.bean.LoginUser;
import com.car.training.dao.BaseDAO;
import com.car.training.service.JobApplyService;
import com.car.training.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bill on 11/19/16.
 */
@Service
public class JobApplyServiceImpl implements JobApplyService {

    @Autowired
    BaseDAO baseDAO;

    @Autowired
    LoginVO loginVO;

    @Override
    @Transactional
    public void apply(int jobId) {
        Apply apply = new Apply();
        LoginUser loginUser = new LoginUser();
        Job job = new Job();
        loginUser.setId(loginVO.getId());
        job.setId(jobId);
        apply.setLoginUser(loginUser);
        apply.setJob(job);
        apply.setApplyTime(new Date());
        baseDAO.save(apply);
    }

    @Override
    @Transactional
    public List<Apply> getAppliedJobs() {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(loginVO.getId());
        HashMap<String, Object> map = new HashMap<>();
        map.put("loginUser", loginUser);
        return (List<Apply>) baseDAO.find(Apply.class, map);
    }
}
