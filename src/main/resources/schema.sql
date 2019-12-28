 DROP TABLE IF EXISTS USERS; 
 
CREATE TABLE USERS (
  studentId INT AUTO_INCREMENT  PRIMARY KEY,
  userName VARCHAR(250) NOT NULL
  
);

INSERT INTO USERS (studentId, userName)
select * from (
    select  1 , 'john' from dual union all
    select 2 , 'andy' from dual union all
    select 3 , 'tim' from dual );
    
    
    DROP TABLE IF EXISTS COURSES; 
 
CREATE TABLE COURSES (
  courseId INT AUTO_INCREMENT  PRIMARY KEY,
  course VARCHAR(250) NOT NULL
  
);

INSERT INTO COURSES (courseId, course)
select * from (
    select  11 , 'java' from dual union all
    select 12 , 'angular' from dual union all
    select 13 , 'spring' from dual );
    
    
    
      DROP TABLE IF EXISTS USERS_COURSES;   
    CREATE TABLE USERS_COURSES (
        userCourseId INT AUTO_INCREMENT  PRIMARY KEY,
        studentId int NOT NULL,
        courseId int NOT NULL,
        percentage VARCHAR(250) NOT NULL
    );
    
    INSERT INTO USERS_COURSES (userCourseId, studentId, courseId, percentage)
select * from (
    select  111, 1, 11 , '0%' from dual );