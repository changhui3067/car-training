package com.car.training.action.website;

import com.car.training.domain.Courses;
import com.car.training.service.CoursesService;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;


@AutoConfig
public class CoursesAction extends BaseAction {

    private static final long serialVersionUID = 4839883380537115435L;

    @Autowired
    private CoursesService coursesService;

    /**
     * 公共课列表
     */
    private ResultPage<Courses> coursesList;
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
        Courses courses = new Courses();
        //按条件筛选培训师列表(包含分页)
        coursesList = coursesService.findPageByCourses(courses, pageSize, pageNo);

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
