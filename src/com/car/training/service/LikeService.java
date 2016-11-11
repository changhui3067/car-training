package com.car.training.service;

/**
 * Created by bill on 11/9/16.
 */
public interface LikeService {
    boolean isLike(int uidA,int uidB);
    boolean isLike(int targetUid);
    boolean like(int targetUid);
    boolean unLike(int targetUid);
}
