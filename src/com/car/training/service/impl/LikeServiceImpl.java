package com.car.training.service.impl;

import com.car.training.bean.Trainer;
import com.car.training.service.LikeService;
import org.springframework.stereotype.Service;

/**
 * Created by bill on 11/9/16.
 */
@Service
public class LikeServiceImpl implements LikeService {
    @Override
    public boolean isLike(int uidA, int uidB) {
        return true;
    }

    @Override
    public boolean isLike(int targetUid) {
        return true;
    }

    @Override
    public boolean isLike(Trainer trainer) {
        return true;
    }

    @Override
    public boolean isLike(int uid, Trainer trainer) {
        return isLike(uid,trainer.getPersonInfo().getId());
    }

    @Override
    public boolean like(int targetUid) {
        return true;
    }

    @Override
    public boolean unLike(int targetUid) {
        return true;
    }

    @Override
    public int likeNumber(int targetUid) {
        return 30;
    }
}
