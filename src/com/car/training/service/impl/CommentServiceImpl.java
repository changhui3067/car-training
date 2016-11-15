package com.car.training.service.impl;

import com.car.training.bean.Comment;
import com.car.training.dao.CommentDAO;
import com.car.training.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bill on 11/10/16.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<Comment> findCommentByTargetUser(int targetUid) {
        return commentDAO.findCommentByTargetUser(targetUid);
    }

    @Override
    public void addComment(int uid, int targetUid, String content) {

        commentDAO.addComment(uid,targetUid,content);
    }


    @Override
    public void deleteComment(int uid, int commentId) {
        commentDAO.deleteComment(uid,commentId);
    }

    @Override
    public int commentNumber(int targetUid){
        return commentDAO.commentCount(targetUid);
    }


}
