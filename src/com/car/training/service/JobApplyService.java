package com.car.training.service;

import com.car.training.bean.Apply;
import com.car.training.bean.Job;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bill on 11/19/16.
 */
public interface JobApplyService {

    void apply(int jobId) throws Exception;

    List<Apply> getApplyListByJob(Job job);

    @Transactional
    boolean hasAppliedToCompany(int companyUid);

    @Transactional
    boolean isApplied(int jobId);

    List<Apply> getApplyListByUser();
}
