package com.car.training.action.website;


import com.car.training.action.SimpleAction;
import com.car.training.bean.Comment;
import com.car.training.bean.Course;
import com.car.training.bean.PersonInfo;
import com.car.training.bean.Trainer;
import com.car.training.enums.UserType;
import com.car.training.service.*;
import com.car.training.vo.LoginVO;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;


@AutoConfig
public class TrainerDetailAction extends SimpleAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private CourseService coursesService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;
    
    @Autowired
    private UserService userService;

    @Autowired
    private JobApplyService jobApplyService;

    private Trainer trainer;

    private List<Comment> commentList;
    /**
     * 培训公开课列表
     */
    private List<Course> coursesList;

    private int trainerId;

    private int likeNumber;

    private boolean like;

    private HashMap<Object,String> commentNameMap = new HashMap<>();

    private boolean hideContact = true;

    private boolean canComment;

    @Override
    public String execute(){
        trainer = trainerService.findById(trainerId);
        if (trainer == null) {
            return redirectToIndex();
        }
        int tUid = trainer.getLoginUser().getId();
        coursesList = coursesService.findByTrainerId(tUid);
        commentList = commentService.findCommentByTargetUser(tUid);
        commentList.forEach((Comment comment)->{
            PersonInfo personInfo = userService.getPersonInfo(comment.getUserId());
            commentNameMap.put(comment,personInfo==null ? "":personInfo.getName());
        });
        likeNumber = likeService.likeNumber(tUid);
        LoginVO loginVO = getLoginVO();
        if(loginVO !=null){
            like = likeService.isLike(loginVO.getId(),tUid);
            if(loginVO.getUserType() == UserType.COMPANY || loginVO.getUserType() == UserType.STORE){
                hideContact = !jobApplyService.hasAppliedToCompany(tUid,loginVO.getId());
            } else{
                canComment = loginVO.getUserType().toString().equals("AUTOBOT");
            }
        }
        return SUCCESS;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public HashMap<Object, String> getCommentNameMap() {
        return commentNameMap;
    }

    public void setCommentNameMap(HashMap<Object, String> commentNameMap) {
        this.commentNameMap = commentNameMap;
    }

    public boolean getHideContact() {
        return hideContact;
    }

    public void setHideContact(boolean hideContact) {
        this.hideContact = hideContact;
    }

    public boolean isCanComment() {
        return canComment;
    }

    public void setCanComment(boolean canComment) {
        this.canComment = canComment;
    }
}
