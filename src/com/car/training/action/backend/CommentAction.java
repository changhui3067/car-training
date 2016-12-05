package com.car.training.action.backend;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Comment;
import com.car.training.bean.LoginUser;
import com.car.training.bean.PersonInfo;
import com.car.training.enums.UserType;
import com.car.training.service.CommentService;
import com.car.training.service.UserService;
import com.car.training.vo.LoginVO;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@AutoConfig
public class CommentAction extends SimpleAction {
    private int targetId;

    private String content;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LoginVO loginVO;

    private List<Comment> commentList;

    @Autowired
    private UserService userService;
    
    private HashMap<Comment,String> commentNameMap = new HashMap<>();


    public String addComment() {
        loginVO = (LoginVO) getHttpSession().getAttribute("loginVO");
        if (loginVO == null){
            return "请登录";
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setId(targetId);
        if (loginVO.getUserType() == UserType.COMPANY || loginVO.getUserType() == UserType.STORE ||
                loginVO.getUserType() == loginUser.getType() || loginVO.getId() == targetId) {
            return errorJSON("没有权限");
        }
        try{
            commentService.addComment(loginVO.getId(), targetId, content);
            commentList = commentService.findCommentByTargetUser(targetId);
            commentList.forEach((Comment comment)->{
                PersonInfo personInfo = userService.getPersonInfo(comment.getUserId());
                commentNameMap.put(comment,personInfo==null ? "":personInfo.getName());
            });
            return "commentListResult";
        }catch (Exception e) {
            return "error";
        }
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<Comment, String> getCommentNameMap() {
        return commentNameMap;
    }

    public void setCommentNameMap(HashMap<Comment, String> commentNameMap) {
        this.commentNameMap = commentNameMap;
    }
}