package com.nelson.springdatajpa.repository;

import com.nelson.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByGuardianName(String guardianName);

    //JPQL
    @Query("select s.firstName from Student s where s.email = ?1")
    String getStudentFirstNameByEmail(String email);

    //SQL - Native Query
    @Query(value = "select * from tbl_student s where s.email = ?1", nativeQuery = true)
    Student getStudentByEmail(String email);

    //SQL - Native Query, Named Param
    @Query(value = "select * from tbl_student s where s.email = :email", nativeQuery = true)
    Student getStudentByEmailParam(@Param("email") String email);


    @Modifying  /*   Added when updating or deleting a record*/
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email = ?2", nativeQuery = true)
    int updateStudentNameByEmail(String firstName, String email);
}
