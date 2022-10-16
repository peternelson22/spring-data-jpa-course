package com.nelson.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(name = "email", columnNames = "email"))
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private  Long studentId;
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;
}
