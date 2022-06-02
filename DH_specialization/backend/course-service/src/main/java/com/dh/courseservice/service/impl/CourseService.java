package com.dh.courseservice.service.impl;

import com.dh.courseservice.exceptions.BusinessError;
import com.dh.courseservice.model.Course;
import com.dh.courseservice.model.dto.SubscriptionDTO;
import com.dh.courseservice.repository.FeignSubscriptionRepository;
import com.dh.courseservice.repository.ICourseRepository;
import com.dh.courseservice.service.ICourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CourseService implements ICourseService {
    private FeignSubscriptionRepository feignSubscriptionRepository;
    private ICourseRepository courseRepository;

    public CourseService(FeignSubscriptionRepository feignSubscriptionRepository, ICourseRepository courseRepository) {
        this.feignSubscriptionRepository = feignSubscriptionRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findById(Integer courseId,Integer userId) throws BusinessError {
        Course course = null;
        ResponseEntity<SubscriptionDTO> response = feignSubscriptionRepository.findByUserId(userId);
        System.out.println("Puerto utilizado: "+response.getHeaders().get("port"));
        SubscriptionDTO subscription = response.getBody();
        Date today = new Date();
        if(!(subscription.getStartDate().before(today) && subscription.getEndDate().after(today)))
            throw  new BusinessError("Subscripcion expirada");

        course = courseRepository.findById(courseId).orElse(null);
        return course;
    }
}
