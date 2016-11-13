package com.car.training.dao;

/**
 * Created by Bill on 11/13/2016.
 */
public interface LikeDAO {
    boolean isLike(int uidA,int uidB);
    boolean isLike(int targetUid);
    boolean like(int targetUid);
    boolean unLike(int targetUid);
    int likeNumber(int targetUid);
}
