package com.ceShop.student.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "COURSES")
public class CourseEntity {

    /*
     * @OneToMany private Set<com.ceShop.student.dto.UserCourseMappingEntity> usercourses;
     */

    @Id
    @Column(name = "COURSEID")
    private Long courseid;

    @Column(name = "COURSE", nullable = false)
    private String course;

}
