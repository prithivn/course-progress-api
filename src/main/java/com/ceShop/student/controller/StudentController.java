package com.ceShop.student.controller;

import java.util.List;

import com.ceShop.student.dto.StudentRequest;
import com.ceShop.student.dto.StudentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ceShop.student.dao.domain.UserCourseMappingEntity;
import com.ceShop.student.exception.RecordNotFoundException;
import com.ceShop.student.processor.StudentProcessor;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/StudentProgress/v1")
public class StudentController {
    @Autowired
    StudentProcessor service;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<UserCourseMappingEntity>> getAllStudents() {
        List<UserCourseMappingEntity> list = service.getAllStudents();

        return new ResponseEntity<List<UserCourseMappingEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/StudentCourse/{id}")
    public ResponseEntity<UserCourseMappingEntity> getStudentById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        UserCourseMappingEntity entity = service.getStudentById(id);

        return new ResponseEntity<UserCourseMappingEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/UpdatePecentage", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserCourseMappingEntity> UpdatePecentage(@RequestBody UserCourseMappingEntity result)
            throws RecordNotFoundException {
        UserCourseMappingEntity updated = service.createOrUpdatePercentage(result);
        return new ResponseEntity<UserCourseMappingEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/UpdatePecentageByID", produces = "application/json", consumes = "application/json")
    public StudentResult UpdatePecentageByID(@RequestBody StudentRequest result)
            throws RecordNotFoundException {
        StudentResult updated = service.UpdatePercentage(result);
        return updated;
    }

}