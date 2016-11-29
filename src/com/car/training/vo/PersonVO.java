package com.car.training.vo;

import com.car.training.bean.Autobot;
import com.car.training.bean.Trainer;

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
    
    public static PersonVO from(Trainer trainer){
        PersonVO personVO = new PersonVO();
        personVO.avatarUrl = trainer.getPersonInfo().getAvatarUrl();
        personVO.personName = trainer.getPersonInfo().getName();
        personVO.currentPosition = trainer.getCurrentPosition();
        personVO.homepageUrl = "/website/trainerDetail?trainerId="+trainer.getId();
        personVO.likeNumber = 1;
        personVO.commentNumber = 1;
        return personVO;
    }

    public static PersonVO from(Autobot autobot){
        PersonVO personVO = new PersonVO();
        personVO.avatarUrl = autobot.getPersonInfo().getAvatarUrl();
        personVO.personName = autobot.getPersonInfo().getName();
        personVO.currentPosition = autobot.getCurrentPosition();
        personVO.homepageUrl = "/website/autobotDetail?autobotId="+autobot.getId();
        personVO.likeNumber = 1;
        personVO.commentNumber = 1;
        return personVO;
    }
    
    public static List<PersonVO> fromTrainerList(List<Trainer> trainers){
        ArrayList<PersonVO> personList = new ArrayList<>();
        for(Trainer trainer:trainers){
            personList.add(from(trainer));
        }
        return personList;
    }

    public static List<PersonVO> fromAutobotList(List<Autobot> autobots){
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
}
