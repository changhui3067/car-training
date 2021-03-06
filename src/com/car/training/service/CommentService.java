package com.car.training.service;

import com.car.training.bean.Comment;

import java.util.List;

/**
 * Created by bill on 11/10/16.
 */
public interface CommentService {
    List<Comment> findCommentByTargetUser(int targetUid);

    void addComment(int uid, int targetUid, String content);

    void deleteComment(int uid, int commentId);

    int commentNumber(int targetUid);
}
