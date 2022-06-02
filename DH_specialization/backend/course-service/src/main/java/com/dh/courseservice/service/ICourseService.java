package com.dh.courseservice.service;

import com.dh.courseservice.exceptions.BusinessError;
import com.dh.courseservice.model.Course;

public interface ICourseService {

    Course findById(Integer courseId,Integer userId) throws BusinessError;
}
