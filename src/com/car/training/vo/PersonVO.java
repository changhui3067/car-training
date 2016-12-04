package com.car.training.vo;

import com.car.training.bean.Autobot;
import com.car.training.bean.Trainer;
import com.car.training.service.CommentService;
import com.car.training.service.LikeService;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bill on 11/29/16.
 */
public class PersonVO {
    private String homepageUrl;
    private String avatarUrl;
    private String personName;
    private int likeNumber;
    private int commentNumber;
    private String currentPosition;
    private Boolean like;
    private int loginUserId;

    private static CommentService commentService;

    private static LikeService likeService;
    
    public static PersonVO from(Trainer trainer){
        PersonVO personVO = new PersonVO();
        personVO.avatarUrl = trainer.getPersonInfo().getAvatarUrl();
        personVO.personName = trainer.getPersonInfo().getName();
        personVO.currentPosition = trainer.getCurrentPosition();
        personVO.homepageUrl = "/website/trainerDetail?trainerId="+trainer.getId();
        personVO.likeNumber = likeService.likeNumber(trainer.getLoginUser().getId());
        personVO.commentNumber = commentService.commentNumber(trainer.getLoginUser().getId());
        LoginVO loginVO = (LoginVO) ServletActionContext.getRequest().getAttribute("loginVO");
        if(loginVO !=null){
            personVO.like = likeService.isLike(loginVO.getId(),trainer.getLoginUser().getId());
        }
        personVO.loginUserId = trainer.getLoginUser().getId();
        return personVO;
    }

    public static PersonVO from(Autobot autobot){
        PersonVO personVO = new PersonVO();
        personVO.avatarUrl = autobot.getPersonInfo().getAvatarUrl();
        personVO.personName = autobot.getPersonInfo().getName();
        personVO.currentPosition = autobot.getCurrentPosition();
        personVO.homepageUrl = "/website/autobotDetail?autobotId="+autobot.getId();
        personVO.likeNumber = likeService.likeNumber(autobot.getLoginUser().getId());
        personVO.commentNumber = commentService.commentNumber(autobot.getLoginUser().getId());
        LoginVO loginVO = (LoginVO) ServletActionContext.getRequest().getAttribute("loginVO");
        if(loginVO !=null){
            personVO.like = likeService.isLike(loginVO.getId(),autobot.getLoginUser().getId());
        }
        personVO.loginUserId = autobot.getLoginUser().getId();
        return personVO;
    }
    
    public static List<PersonVO> fromTrainerList(List<Trainer> trainers, CommentService commentService, LikeService likeService){
        PersonVO.commentService = commentService;
        PersonVO.likeService = likeService;        
        ArrayList<PersonVO> personList = new ArrayList<>();
        for(Trainer trainer:trainers){
            personList.add(from(trainer));
        }
        return personList;
    }

    public static List<PersonVO> fromAutobotList(List<Autobot> autobots, CommentService commentService, LikeService likeService){
        PersonVO.commentService = commentService;
        PersonVO.likeService = likeService;
        ArrayList<PersonVO> personList = new ArrayList<>();
        for(Autobot autobot:autobots){
            personList.add(from(autobot));
        }
        return personList;
    }
    
    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public int getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(int loginUserId) {
        this.loginUserId = loginUserId;
    }
}
