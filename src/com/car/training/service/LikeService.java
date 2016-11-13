package com.car.training.service;

import com.car.training.bean.Trainer;

/**
 * Created by bill on 11/9/16.
 */
public interface LikeService {
    boolean isLike(int uidA,int uidB);
    boolean isLike(int targetUid);
    boolean isLike(Trainer trainer);
    boolean isLike(int uid,Trainer trainer);

    boolean like(int targetUid);
    boolean unLike(int targetUid);
    int likeNumber(int targetUid);
    int likeNumber(Trainer trainer);
}
