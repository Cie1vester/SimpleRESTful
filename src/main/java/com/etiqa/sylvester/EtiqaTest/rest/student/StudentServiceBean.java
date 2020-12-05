package com.etiqa.sylvester.EtiqaTest.rest.student;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceBean implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() throws Exception {
        List<Student> studentList = null;
        System.out.println("getAllStudents service bean");
        try {
            studentList = studentDao.findAll();
            System.out.println("getAllStudents service bean " + studentList.size());
        } catch (Exception e) {
            // Nice to have: can add custom/user exception here
            throw e;
        }

        return studentList;
    }

    @Override
    public void addStudent(Student student) throws Exception {
        studentDao.save(student);
    }

    @Override
    public void updateStudentByPK(Student student) throws Exception {
        // if id is NOT null, empty, or empty when using String.trim()
        if (Strings.isNotBlank(student.getId().toString())) {
            if (studentDao.existsById(student.getId())) {
                studentDao.save(student);
            } else {
                // if student doesn't exist
                throw new Exception(); // Nice to have: can add custom/user exception here
            }
        } else {
            // if id is null
            throw new Exception(); // Nice to have: can add custom/user exception here
        }
    }

    @Override
    public void deleteStudent(Integer id) throws Exception {
        if (Strings.isNotBlank(id.toString())) {
            System.out.println("delete ID ::: " + id);
            studentDao.deleteById(id);
        } else {
            //invalid id
            throw new Exception(); // Nice to have: can add custom/user exception here
        }
    }

}
