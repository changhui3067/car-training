package com.car.training.action.website;


import com.car.training.bean.Comment;
import com.car.training.bean.Course;
import com.car.training.bean.Trainer;
import com.car.training.service.CommentService;
import com.car.training.service.CourseService;
import com.car.training.service.TrainerService;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@AutoConfig
public class TrainerDetailAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TrainerService trainerService;
    @Autowired
    private CourseService coursesService;
//    @Autowired
//    private TrainerEssayService trainerEssayService;
    @Autowired
    private CommentService commentService;

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

    @Override
    public String execute(){
        trainer = trainerService.findById(trainerId);
        if (trainer == null) {
            setTargetUrl("/website/index");
            return REDIRECT;
        }

        coursesList = coursesService.findByTrainerId(trainerId);
        commentList = commentService.findCommentByTargetUser(trainerId);
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
}
