package com.nelson.springdatajpa.repository;

import com.nelson.springdatajpa.entity.Course;
import com.nelson.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("MBBS")
                .credit(6)
                .build();


        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void showCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }
}