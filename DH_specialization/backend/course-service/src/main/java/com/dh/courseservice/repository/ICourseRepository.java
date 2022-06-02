package com.dh.courseservice.repository;

import com.dh.courseservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course,Integer> {


}
