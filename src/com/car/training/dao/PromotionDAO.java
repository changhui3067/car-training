package com.car.training.dao;

import com.car.training.bean.Job;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bill on 11/21/16.
 */
public interface PromotionDAO {
    boolean isUpTodate();

    List getTopUser(Class tClass);

    List<Job> getTopJob(String type);

    void updatePromotion();
}
