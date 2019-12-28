package com.ceShop.student.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS_COURSES")
public class UserCourseMappingEntity  {

    @ManyToOne
    @JoinColumn(name = "studentid", nullable = false)
    private UserEntity users;

    @ManyToOne
    @JoinColumn(name = "courseid", nullable = false)
    private CourseEntity courses;

    @Id
    @Column(name = "USERCOURSEID")
    private Long usercourseid;

    @Column(name = "PERCENTAGE", nullable = false)
    private String percentage;

}
