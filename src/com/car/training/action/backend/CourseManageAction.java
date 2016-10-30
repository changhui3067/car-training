package com.car.training.action.backend;

import com.car.training.domain.Courses;
import com.car.training.service.CoursesService;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

@AutoConfig
public class CourseManageAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private CoursesService coursesService;
    /**
     * 公开课列表
     */
    private ResultPage<Courses> coursesList;
    /**
     * 公开课
     */
    private Courses course;
    /**
     * 页大小
     */
    private Integer pageSize = 10;
    /**
     * 页号
     */
    private Integer pageNo = 1;

    @Override
    public String execute() throws Exception {
        coursesList = coursesService.findPageByCourses(new Courses(), pageSize, pageNo);
        return SUCCESS;
    }

    /**
     * 公开课新增&編輯
     */
    public String essaySave() throws Exception {
        coursesService.save(course);
        return SUCCESS;
    }

    /**
     * 公开课删除
     */
    public String essayDelete() throws Exception {
        coursesService.delete(course.getId());
        return SUCCESS;
    }

    public ResultPage<Courses> getCoursesList() {
        return coursesList;
    }


    public void setCoursesList(ResultPage<Courses> coursesList) {
        this.coursesList = coursesList;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
