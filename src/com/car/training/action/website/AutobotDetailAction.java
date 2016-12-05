package com.car.training.action.website;

import com.car.training.action.SimpleAction;
import com.car.training.bean.*;
import com.car.training.service.*;
import com.car.training.vo.LoginVO;
import org.ironrhino.core.metadata.AutoConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
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

    private boolean like;

    private List<Comment> commentList;

    @Autowired
    private UserService userService;
    
    private HashMap<Comment,String> commentNameMap = new HashMap<>();


    @Override
    public String execute(){
        autobot = autobotService.findById(autobotId);

        if (autobot == null) {
            return redirectToIndex();
        }
        int aUid = autobot.getLoginUser().getId();
        commentList = commentService.findCommentByTargetUser(aUid);
        likeNumber = likeService.likeNumber(aUid);
        LoginVO loginVO = (LoginVO)getHttpSession().getAttribute("loginVO");
        if(loginVO !=null){
            like = likeService.isLike(loginVO.getId(),aUid);
        }
        commentList.forEach((Comment comment)->{
            PersonInfo personInfo = userService.getPersonInfo(comment.getUserId());
            commentNameMap.put(comment,personInfo==null ? "":personInfo.getName());
        });
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


    public HashMap<Comment, String> getCommentNameMap() {
        return commentNameMap;
    }

    public void setCommentNameMap(HashMap<Comment, String> commentNameMap) {
        this.commentNameMap = commentNameMap;
    }
}
