package com.nelson.springdatajpa.repository;

import com.nelson.springdatajpa.entity.Course;
import com.nelson.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    private void saveTeacher(){

        Course course1 = Course.builder()
                .title("ENG23")
                .credit(3)
                .build();

        Course course2 = Course.builder()
                .title("ENG44")
                .credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Tony")
                .lastName("Paul")
                //.courses(List.of(course1, course2)) when one-to-one was removed
                .build();
        teacherRepository.save(teacher);
    }
}