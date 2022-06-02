package com.dh.courseservice.controllers;

import com.dh.courseservice.exceptions.BusinessError;
import com.dh.courseservice.model.Course;
import com.dh.courseservice.service.ICourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseRestController {
    private ICourseService courseService;

    public CourseRestController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}")
    public Course findById(@PathVariable Integer courseId, @RequestHeader(value = "userId", required = true) Integer userId) throws BusinessError {
        return courseService.findById(courseId,userId);
    }
}
