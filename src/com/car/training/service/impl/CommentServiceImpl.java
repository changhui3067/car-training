package com.car.training.service.impl;

import com.car.training.bean.Comment;
import com.car.training.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bill on 11/10/16.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public List<Comment> findCommentByTargetUser(int targetUid) {
        return null;
    }
}
