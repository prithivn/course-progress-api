package com.ceShop.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class StudentRequest {

    private Long usercourseid;
    private Integer studentid;
    private Integer courseid;
    private String percentage;
}
