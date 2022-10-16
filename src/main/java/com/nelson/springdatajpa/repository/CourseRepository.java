package com.nelson.springdatajpa.repository;

import com.nelson.springdatajpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
}
