package com.car.training.service.impl;

import com.car.training.service.LikeService;
import org.springframework.stereotype.Service;

/**
 * Created by bill on 11/9/16.
 */
@Service
public class LikeServiceImpl implements LikeService {
    @Override
    public boolean isLike(int uidA, int uidB) {
        return false;
    }

    @Override
    public boolean isLike(int targetUid) {
        return false;
    }

    @Override
    public void like(int targetUid) {

    }

    @Override
    public void unLike(int targetUid) {

    }
}
