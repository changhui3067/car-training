package com.car.training.service.impl;

import com.car.training.bean.*;
import com.car.training.dao.BaseDAO;
import com.car.training.enums.UserType;
import com.car.training.service.AutobotService;
import com.car.training.service.JobApplyService;
import com.car.training.service.TrainerService;
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

    @Autowired
    TrainerService trainerService;

    @Autowired
    AutobotService autobotService;

    @Override
    @Transactional
    public void apply(int jobId) throws Exception {
        if(isApplied(jobId)){
            throw new Exception("already applied");
        }
        
        Apply apply = new Apply();
        LoginUser loginUser = new LoginUser();
        Job job = new Job();
        loginUser.setId(loginVO.getId());
        job.setId(jobId);
        
        
        
        switch (loginVO.getUserType()) {
            case TRAINER:
                Trainer trainer = trainerService.findByLoginUser(loginUser);
                apply.setTrainer(trainer);
                apply.setAutobot(new Autobot());
                break;
            case AUTOBOT:
                Autobot autobot = autobotService.findByLoginUser(loginUser);
                apply.setAutobot(autobot);
                apply.setTrainer(new Trainer());
                break;
            default:
                break;
        }

        apply.setJob(job);
        apply.setApplyTime(new Date());
        baseDAO.save(apply);
    }

    @Override
    @Transactional
    public boolean isApplied(int jobId){
        for ( Apply apply : getApplyListByUser()){
            if (apply.getJob().getId() == jobId){
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    @Transactional
    public List<Apply> getApplyListByUser() {
        HashMap<String, Object> map = new HashMap<>();

        LoginUser loginUser = new LoginUser();
        loginUser.setId(loginVO.getId());
        switch (loginVO.getUserType()) {
            case TRAINER:
                Trainer trainer = trainerService.findByLoginUser(loginUser);
                map.put("trainer", trainer);
                break;
            case AUTOBOT:
                Autobot autobot = autobotService.findByLoginUser(loginUser);
                map.put("autobot", autobot);
            default:
                break;
        }

        return (List<Apply>) baseDAO.find(Apply.class, map);
    }

    @Override
    @Transactional
    public List<Apply> getApplyListByJob(Job job) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("job", job);
        return (List<Apply>) baseDAO.find(Apply.class, map);
    }
}
