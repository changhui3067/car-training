package com.car.training.action.website;

import com.car.training.domain.AutobotsComment;
import com.car.training.domain.Courses;
import com.car.training.service.AutobotsCommentService;
import com.car.training.service.CoursesService;
import org.apache.commons.lang3.StringUtils;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AutoConfig
public class CourseDetailAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private CoursesService courseService;

    private Courses course;
    /**
     * 学员评论列表
     */
    private List<AutobotsComment> autobotsCommentList;
    @Autowired
    private AutobotsCommentService autobotsCommentService;

    @Override
    public String execute() throws Exception {
        Courses t = new Courses();
        if (course != null && StringUtils.isNotBlank(course.getId())) {
            t.setId(course.getId());
        }
        course = courseService.findById(t.getId());
        if (course != null && course.getTrainer() != null) {
            AutobotsComment autobotsComment = new AutobotsComment();
            autobotsComment.setTrainer(course.getTrainer());
            autobotsCommentList = autobotsCommentService.findListByAutobotsComment(autobotsComment);
        }
        return SUCCESS;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public List<AutobotsComment> getAutobotsCommentList() {
        return autobotsCommentList;
    }

    public void setAutobotsCommentList(List<AutobotsComment> autobotsCommentList) {
        this.autobotsCommentList = autobotsCommentList;
    }

}
