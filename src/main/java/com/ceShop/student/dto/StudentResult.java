package com.ceShop.student.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class StudentResult {

    private Long usercourseid;
    private Long studentid;
    private Long courseid;
    private String percentage;
    private boolean updated;
}
