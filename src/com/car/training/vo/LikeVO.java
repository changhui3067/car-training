package com.car.training.vo;

/**
 * Created by Bill on 11/13/2016.
 */
public class LikeVO {
    boolean isLike;
    int likeNumber;

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }
}
