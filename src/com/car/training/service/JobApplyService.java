package com.car.training.service;

import com.car.training.bean.Apply;
import com.car.training.bean.Job;
import com.car.training.vo.LoginVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bill on 11/19/16.
 */
public interface JobApplyService {

    boolean isApplied(int jobId, int uid);

    List<Apply> getApplyListByUser(int uid);

    List<Apply> getApplyListByJob(Job job);

    void apply(int jobId, LoginVO loginVO) throws Exception;

    boolean hasAppliedToCompany(int uid, int companyUid);

}
