package com.car.training.service;

import com.car.training.bean.Trainer;

/**
 * Created by bill on 11/9/16.
 */
public interface LikeService {
    boolean like(int uid, int targetUid);
    boolean unLike(int uid, int targetUid);
    boolean isLike(int uid,int targetUid);
    int likeNumber(int targetUid);
}
