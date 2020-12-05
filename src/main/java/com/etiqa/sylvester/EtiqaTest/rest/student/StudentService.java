package com.etiqa.sylvester.EtiqaTest.rest.student;

import java.util.List;

//Nice to have: an interface is good to have in case there are different implementations of the same method
public interface StudentService {

    public List<Student> getAllStudents() throws Exception;
    
    public void addStudent(Student student) throws Exception;

    void updateStudentByPK(Student student) throws Exception;

    void deleteStudent(Integer id) throws Exception;

    List<Student> findStudentByCourseId(String courseId) throws Exception;
}
