package com.car.training.service;

/**
 * Created by bill on 11/9/16.
 */
public interface LikeService {
    boolean isLike(int uidA,int uidB);
    boolean isLike(int targetUid);
    void like(int targetUid);
    void unLike(int targetUid);
}
