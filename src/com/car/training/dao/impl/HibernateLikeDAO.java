package com.car.training.dao.impl;

import com.car.training.dao.LikeDAO;

/**
 * Created by Bill on 11/13/2016.
 */
public class HibernateLikeDAO implements LikeDAO {
    @Override
    public boolean isLike(int uidA, int uidB) {
        return false;
    }

    @Override
    public boolean isLike(int targetUid) {
        return false;
    }

    @Override
    public boolean like(int targetUid) {
        return false;
    }

    @Override
    public boolean unLike(int targetUid) {
        return false;
    }

    @Override
    public int likeNumber(int targetUid) {
        return 0;
    }
}
