package com.nelson.springdatajpa.repository;

import com.nelson.springdatajpa.entity.Course;
import com.nelson.springdatajpa.entity.Student;
import com.nelson.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void showCourses(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Hope")
                .lastName("Emma")
                .build();

        Course course = Course.builder()
                .title("JAVA")
                .credit(5)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findALlPagination(){
        Pageable firstPage = PageRequest.of(0,2);
        Pageable secondPage = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(firstPage).getContent();

        long totalElements = courseRepository.findAll(firstPage).getTotalElements();

        long totalPages = courseRepository.findAll(firstPage).getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("title").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);

    }

    @Test  //Getting Pageable with title of page
    public void findByTitleContaining(){
        Pageable firstTen = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("NEL", firstTen).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Hope")
                .lastName("Chile")
                .build();

        Student student = Student.builder()
                .firstName("John")
                .lastName("Smith")
                .email("smith@gmail.com")
                .build();

        Course course = Course.builder()
                .title("PYTHON")
                .credit(6)
                .teacher(teacher)
                .build();
        course.addStudents(student);

        courseRepository.save(course);
    }


}