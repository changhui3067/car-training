package com.car.training.service;

import com.car.training.model.Courses;
import org.ironrhino.core.model.ResultPage;
import org.ironrhino.core.service.BaseManager;

import java.util.List;

public interface CoursesManager extends BaseManager<Courses> {

    /**
     * 新增公开课信息
     */
    void save(Courses courses);

    /**
     * 更新公开课信息
     */
    void update(Courses courses);

    /**
     * 删除公开课信息
     */
    void delete(String id);

    /**
     * 获取公开课信息
     **/
    Courses findById(String id);

    /**
     * 获取公开课列表
     */
    ResultPage<Courses> findPageByCourses(Courses courses, Integer pageSize, Integer pageNo);

    /**
     * 获取公开课列表
     */
    List<Courses> findListByCourses(Courses courses);

    /**
     * 获取公开课列表首页2个位置
     */
    List<Courses> findByIndexPromoted(Boolean promote, Integer count);

}
