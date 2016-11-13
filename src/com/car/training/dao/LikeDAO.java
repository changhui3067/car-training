package com.car.training.dao;

/**
 * Created by Bill on 11/13/2016.
 */
public interface LikeDAO {
    boolean isLike(int uidA,int uidB);

    boolean like(int uid ,int targetUid);

    boolean unLike(int uid , int targetUid);

    int likeNumber(int targetUid);
}
