package com.car.training.service.impl;

import com.car.training.bean.Trainer;
import com.car.training.dao.LikeDAO;
import com.car.training.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bill on 11/9/16.
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeDAO likeDAO;


    @Override
    public boolean like(int uid, int targetUid) {
        return likeDAO.like(uid,targetUid);
    }

    @Override
    public boolean unLike(int uid, int targetUid) {
        return likeDAO.unLike(uid,targetUid);
    }

    @Override
    public boolean isLike(int uid, int targetUid) {
        return likeDAO.isLike(uid,targetUid);
    }

    @Override
    public int likeNumber(int targetUid) {
        return likeDAO.likeNumber(targetUid);
    }
}
