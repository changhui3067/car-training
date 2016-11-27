package com.car.training.action.website;


import com.car.training.action.SimpleAction;
import com.car.training.bean.Comment;
import com.car.training.bean.Course;
import com.car.training.bean.Trainer;
import com.car.training.service.CommentService;
import com.car.training.service.CourseService;
import com.car.training.service.LikeService;
import com.car.training.service.TrainerService;
import com.car.training.vo.LoginVO;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

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


//    @Autowired
//    private TrainerEssayService trainerEssayService;

    private Trainer trainer;
//    /**
//     * 学员评论列表
//     */
    private List<Comment> commentList;
//    /**
//     * 学员评论列表
//     */
//    private List<TrainerEssay> trainerEssayList;
    /**
     * 培训公开课列表
     */
    private List<Course> coursesList;

    private int trainerId;

    private int likeNumber;

    private boolean like;


    @Override
    public String execute(){
        trainer = trainerService.findById(trainerId);
        if (trainer == null) {
            return redirectToIndex();
        }
        int tUid = trainer.getPersonInfo().getId();
        coursesList = coursesService.findByTrainerId(tUid);
        commentList = commentService.findCommentByTargetUser(tUid);
        likeNumber = likeService.likeNumber(tUid);
        LoginVO loginVO = (LoginVO)getHttpSession().getAttribute("loginVO");
        if(loginVO !=null){
            like = likeService.isLike(loginVO.getId(),tUid);
        }
        return SUCCESS;
//
//        TrainerEssay trainerEssay = new TrainerEssay();
//        trainerEssay.setTrainer(trainer);
//        trainerEssayList = trainerEssayService.findListByTrainerEssay(trainerEssay);
//        trainer.setTrainerEssayList(trainerEssayList);


    }

//    @JsonConfig(root = "data")
//    public String commentTrainer() throws Exception {
//        HttpServletRequest request = ServletActionContext.getRequest();
//        UserCenter uc = new UserCenter();
//        Map<String, Object> map = new HashMap<String, Object>();
//        uc = (UserCenter) request.getSession().getAttribute("userDetails");
//        if (uc == null || !uc.getPersonalType().equals(PersonalType.AUTOBOT)) {
//            map.put("code", 400);
//            map.put("msg", "您还没有登陆或您不是汽车人，不能添加评论！");
//        } else {
//            AutobotsComment autobotsComment = new AutobotsComment();
//            trainer = trainerService.findById(tid);
//            autobotsComment.setTrainer(trainer);
//            autobotsComment.setContent(content);
//            autobotsComment.setCreateDate(new Date());
//            autobotsComment.setAutobots(uc.getAutobot());
//            autobotsComment.setEnabled(true);
//            autobotsCommentService.save(autobotsComment);
//            map.put("code", 200);
//            map.put("msg", "评论成功！");
//        }
//        setData(map);
//        return JSON;
//    }
//
//    @JsonConfig(root = "data")
//    public String dianzan() throws Exception {
//        Map<String, Object> map = new HashMap<String, Object>();
//        trainer = trainerService.findById(tid);
//        trainer.setStarLevel(trainer.getStarLevel() + 1);
//        trainerService.update(trainer);
//
//        map.put("code", 200);
//        map.put("msg", "评论成功！");
//        setData(map);
//        return JSON;
//    }

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
}
