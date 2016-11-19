package com.car.training.service;

import com.car.training.bean.Apply;

import java.util.List;

/**
 * Created by bill on 11/19/16.
 */
public interface JobApplyService {

    void apply(int jobId);

    List<Apply> getAppliedJobs();
}
