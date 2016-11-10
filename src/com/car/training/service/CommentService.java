package com.car.training.service;

import com.car.training.bean.Comment;

import java.util.List;

/**
 * Created by bill on 11/10/16.
 */
public interface CommentService {
    List<Comment> findCommentByTargetUser(int targetUid);
}
