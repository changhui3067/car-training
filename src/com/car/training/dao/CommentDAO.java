package com.car.training.dao;

import com.car.training.bean.Comment;

import java.util.List;

/**
 * Created by bill on 11/16/16.
 */
public interface CommentDAO {

    List<Comment> findCommentByTargetUser(int targetUid);

    void addComment(int uid, int targetUid, String content);

    void deleteComment(int uid, int commentId);

    int commentCount(int targetUid);
}
