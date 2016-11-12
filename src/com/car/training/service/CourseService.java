package com.car.training.service;

import com.car.training.bean.Course;

import java.util.List;

/**
 * Created by bill on 11/10/16.
 */
public interface CourseService {
    List<Course> findByTrainerId(int trainerId);
}
