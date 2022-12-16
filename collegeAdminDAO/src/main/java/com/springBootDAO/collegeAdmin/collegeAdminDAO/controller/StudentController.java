package com.springBootDAO.collegeAdmin.collegeAdminDAO.controller;

import com.springBootDAO.collegeAdmin.collegeAdminDAO.model.Student;
import com.springBootDAO.collegeAdmin.collegeAdminDAO.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")// localhost:8080/dashboard
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create-student")// localhost:8080/dashboard/create-student
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/get-student-json") // localhost:8080/dashboard/get-student-json
    public Student getStudentJSON() {
        return new Student();
    }

    @GetMapping("/get-all-student") // localhost:8080/dashboard/get-all-student
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/get-student-by-name/{name}") // localhost:8080/dashboard/get-student-by-name/{name}
    public Student getStudentByName(@PathVariable("name") String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/get-student-by-id/{id}") // localhost:8080/dashboard/get-student-by-id/{id}
    public Student getStudentById(@PathVariable("id") long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update-student-by-id/{id}") // localhost:8080/dashboard/update-student-by-id/{id}
    public Student updateStudentById(@PathVariable("id") long id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }

    @PutMapping("/update-student-by-name/{name}") // localhost:8080/dashboard/update-student-by-name/{name}
    public Student updateStudentByName(@PathVariable String name, @RequestBody Student student) {
        return studentService.updateStudentByName(name, student);
    }

    @DeleteMapping("/delete-student-by-id/{id}") // localhost:8080/dashboard/delete-student-by-id/{id}
    public String deleteStudentById(@PathVariable long id) {
        return studentService.deleteStudentById(id);
    }

}
