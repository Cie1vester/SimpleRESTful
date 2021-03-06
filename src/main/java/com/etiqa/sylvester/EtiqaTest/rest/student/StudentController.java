package com.etiqa.sylvester.EtiqaTest.rest.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //create
    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addStudent(@RequestBody Student request) throws Exception {
        studentService.addStudent(request);
    }

    //read
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getAllStudents() throws Exception {
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    //delete
    @RequestMapping(value = "/{courseid}", method = RequestMethod.GET)
    public List<Student> getStudentByCourseId(@PathVariable("courseid") String courseId)
            throws Exception {
        return studentService.findStudentByCourseId(courseId);
    }

    //update
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updateStudentById(@RequestBody Student request) throws Exception {
        studentService.updateStudentByPK(request);
    }

    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") Integer id) throws Exception {
        studentService.deleteStudent(id);
    }

}
