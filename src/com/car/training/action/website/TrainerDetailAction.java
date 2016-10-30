package com.car.training.action.website;

import com.car.training.domain.*;
import com.car.training.enums.PersonalType;
import com.car.training.service.AutobotsCommentService;
import com.car.training.service.CoursesService;
import com.car.training.service.TrainerEssayService;
import com.car.training.service.TrainerService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.JsonConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@AutoConfig
public class TrainerDetailAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private TrainerService trainerService;
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private TrainerEssayService trainerEssayService;
    @Autowired
    private AutobotsCommentService autobotsCommentService;

    private Trainer trainer;
    /**
     * 学员评论列表
     */
    private List<AutobotsComment> autobotsCommentList;
    /**
     * 学员评论列表
     */
    private List<TrainerEssay> trainerEssayList;
    /**
     * 培训公开课列表
     */
    private List<Courses> coursesList;
    private String tid;
    private Object data;
    private String content;

    @Override
    public String execute() throws Exception {
        Trainer t = new Trainer();
        if (trainer != null && StringUtils.isNotBlank(trainer.getId())) {
            t.setId(trainer.getId());
        }
        trainer = trainerService.findById(t.getId());
        if (trainer != null) {
            Courses course = new Courses();
            course.setTrainer(trainer);
            coursesList = coursesService.findListByCourses(course);
            trainer.setCoursesList(coursesList);

            TrainerEssay trainerEssay = new TrainerEssay();
            trainerEssay.setTrainer(trainer);
            trainerEssayList = trainerEssayService.findListByTrainerEssay(trainerEssay);
            trainer.setTrainerEssayList(trainerEssayList);

            AutobotsComment autobotsComment = new AutobotsComment();
            autobotsComment.setTrainer(trainer);
            autobotsCommentList = autobotsCommentService.findListByAutobotsComment(autobotsComment);
            trainer.setAutobotsCommentList(autobotsCommentList);
        }
        return SUCCESS;
    }

    @JsonConfig(root = "data")
    public String commentTrainer() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        UserCenter uc = new UserCenter();
        Map<String, Object> map = new HashMap<String, Object>();
        uc = (UserCenter) request.getSession().getAttribute("userDetails");
        if (uc == null || !uc.getPersonalType().equals(PersonalType.AUTOBOT)) {
            map.put("code", 400);
            map.put("msg", "您还没有登陆或您不是汽车人，不能添加评论！");
        } else {
            AutobotsComment autobotsComment = new AutobotsComment();
            trainer = trainerService.findById(tid);
            autobotsComment.setTrainer(trainer);
            autobotsComment.setContent(content);
            autobotsComment.setCreateDate(new Date());
            autobotsComment.setAutobots(uc.getAutobot());
            autobotsComment.setEnabled(true);
            autobotsCommentService.save(autobotsComment);
            map.put("code", 200);
            map.put("msg", "评论成功！");
        }
        setData(map);
        return JSON;
    }

    @JsonConfig(root = "data")
    public String dianzan() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        trainer = trainerService.findById(tid);
        trainer.setStarLevel(trainer.getStarLevel() + 1);
        trainerService.update(trainer);

        map.put("code", 200);
        map.put("msg", "评论成功！");
        setData(map);
        return JSON;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<AutobotsComment> getAutobotsCommentList() {
        return autobotsCommentList;
    }

    public void setAutobotsCommentList(List<AutobotsComment> autobotsCommentList) {
        this.autobotsCommentList = autobotsCommentList;
    }

    public List<TrainerEssay> getTrainerEssayList() {
        return trainerEssayList;
    }

    public void setTrainerEssayList(List<TrainerEssay> trainerEssayList) {
        this.trainerEssayList = trainerEssayList;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
