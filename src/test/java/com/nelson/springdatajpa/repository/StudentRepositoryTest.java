package com.nelson.springdatajpa.repository;

import com.nelson.springdatajpa.entity.Guardian;
import com.nelson.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .email("nelson@gmail.com")
                .firstName("nelson")
                .lastName("tanko")
                //.guardianEmail("tanko@gmail.com")
                //.guardianMobile("099999909")
                //.guardianName("wisdom")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("olowo")
                .email("olow@gmail.com")
                .mobile("000090089")
                .build();

        Student student = Student.builder()
                .email("emma@gmail.com")
                .firstName("emma")
                .lastName("pelumi")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    
    @Test
    public void showAllStudents(){
        List<Student> students = studentRepository.findAll();

        System.out.println("students = " + students);
    }

    @Test
    public void showStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstNameContaining("em");
        System.out.println("students = " + students);
    }

    @Test
    public void showStudentByGuardianName(){
       List<Student> students = studentRepository.findByGuardianName("olowo");
        System.out.println("students = " + students);
    }
    @Test
    public void showStudentByEmail(){
        String student = studentRepository.getStudentFirstNameByEmail("nelson@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void showStudentByEmailNative(){
        Student student = studentRepository.getStudentByEmail("nelson@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailParam(){
        Student student = studentRepository.getStudentByEmailParam("nelson@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentByEmail(){
        studentRepository.updateStudentNameByEmail("nello", "nelson@gmail.com");
    }
}