package com.nelson.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private  Long courseMaterialId;

    private String url;

    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;


   /* public CourseMaterial(String url, Course course) {
        this.url = url;
        this.course = course;
    }*/
}
