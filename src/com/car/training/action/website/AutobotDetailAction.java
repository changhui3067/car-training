package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.Autobot;
import com.car.training.bean.Comment;
import com.car.training.bean.Course;
import com.car.training.bean.Trainer;
import com.car.training.service.*;
import com.car.training.vo.LoginVO;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@AutoConfig
public class AutobotDetailAction extends SimpleAction {

    private static final long serialVersionUID = 4839883380537115435L;


    @Autowired
    private AutobotService autobotService;


    @Autowired
    private CourseService coursesService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    private Autobot autobot;

    private List<Trainer> trainerList;

    private int autobotId;

    /**
     * 朋友圈汽车人列表
     */
    private List<Autobot> autobotsList;


    private int likeNumber;

    private boolean isLike;

    private List<Comment> commentList;


    @Override
    public String execute(){
        autobot = autobotService.findById(autobotId);

        if (autobot == null) {
            return redirectToIndex();
        }
        int aUid = autobot.getPersonInfo().getId();
        commentList = commentService.findCommentByTargetUser(aUid);
        likeNumber = likeService.likeNumber(aUid);
        LoginVO loginVO = (LoginVO)getHttpSession().getAttribute("loginVO");
        if(loginVO !=null){
            isLike = likeService.isLike(loginVO.getId(),aUid);
        }

//        for (String strId : autobots.getAttentionTrainer().split(",")) {
//            if (StringUtils.isNotBlank(strId)) {
//                Trainer trainer = trainerService.findById(strId);
//                if (trainer != null) {
//                    listTrainer.add(trainer);
//                }
//            }
//        }
//        autobots.setAttentionTrainerList(listTrainer);
//        //朋友圈
//        autobotsList = autobotsService.findByIndexPromoted(true, 6);
        return SUCCESS;
    }

    public Autobot getAutobot() {
        return autobot;
    }

    public void setAutobot(Trainer trainer) {
        this.autobot = autobot;
    }

    public void setAutobotId(int autobotId) {
        this.autobotId = autobotId;
    }

    public int getAutobotId() {
        return autobotId;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
