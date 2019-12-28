package com.ceShop.student.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ceShop.student.dto.StudentRequest;
import com.ceShop.student.dto.StudentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceShop.student.dao.StudentRepository;
import com.ceShop.student.dao.domain.UserCourseMappingEntity;
import com.ceShop.student.exception.RecordNotFoundException;

@Service
public class StudentProcessor {
    @Autowired
    StudentRepository repository;
    @Autowired
    StudentResult result;
    private Object RecordNotFoundException;

    public List<UserCourseMappingEntity> getAllStudents() {
        List<UserCourseMappingEntity> employeeList = repository.findAll();

        if (employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<UserCourseMappingEntity>();
        }
    }

    public UserCourseMappingEntity getStudentById(Long id) throws RecordNotFoundException {
        Optional<UserCourseMappingEntity> student = repository.findById(id);

        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public UserCourseMappingEntity createOrUpdatePercentage(UserCourseMappingEntity entity)
            throws RecordNotFoundException {
        Optional<UserCourseMappingEntity> student = repository.findById(entity.getUsercourseid());

        if (student.isPresent()) {
            UserCourseMappingEntity newEntity = student.get();
            newEntity.setUsercourseid(entity.getUsercourseid());
            newEntity.setUsers(entity.getUsers());
            newEntity.setCourses(entity.getCourses());
            newEntity.setPercentage(entity.getPercentage());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public StudentResult UpdatePercentage(StudentRequest entity)
            throws RecordNotFoundException {
        Optional<UserCourseMappingEntity> student = repository.findById(entity.getUsercourseid());

        if (student.isPresent()) {
            UserCourseMappingEntity newEntity = student.get();
            newEntity.setUsercourseid(entity.getUsercourseid());
            newEntity.setPercentage(entity.getPercentage());

            newEntity = repository.save(newEntity);
            result.setUsercourseid(newEntity.getUsercourseid());
            result.setStudentid(newEntity.getUsers().getStudentid());
            result.setCourseid(newEntity.getCourses().getCourseid());
            result.setPercentage(newEntity.getPercentage());
            result.setUpdated(true);
            return result;
        }
        else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

}
