package com.ceShop.student.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class UserEntity {

    /*
     * @OneToMany private Set<com.ceShop.student.dto.UserCourseMappingEntity> usercourses;
     */

    @Id
    @Column(name = "STUDENTID")
    private Long studentid;

    @Column(name = "USERNAME", nullable = false)
    private String userName;

}
