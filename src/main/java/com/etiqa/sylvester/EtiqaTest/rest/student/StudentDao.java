package com.etiqa.sylvester.EtiqaTest.rest.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {
    
    List<Student> findStudentByCourseId(String courseId);
}
