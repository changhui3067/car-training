package com.car.training.service.impl;

import com.car.training.bean.Course;
import com.car.training.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bill on 11/10/16.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> findByTrainerId(int trainerId) {
        return null;
    }
}
