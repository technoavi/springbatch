package com.springBootDAO.collegeAdmin.collegeAdminDAO.controller;

import com.springBootDAO.collegeAdmin.collegeAdminDAO.model.Student;
import com.springBootDAO.collegeAdmin.collegeAdminDAO.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create-student")
    @ResponseBody
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/get-student-json")
    @ResponseBody
    public Student getStudentJSON() {
        return new Student();
    }

    @GetMapping("/get-all-student")
    @ResponseBody
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/get-student-by-name/{name}")
    @ResponseBody
    public Student getStudentByName(@PathVariable("name") String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/get-student-by-id/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable("id") long id) {
        return studentService.getStudentById(id);
    }

    @ResponseBody
    @PutMapping("/update-student-by-id/{id}")
    public Student updateStudentById(@PathVariable("id") long id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }

    @ResponseBody
    @PutMapping("/update-student-by-name/{name}")
    public Student updateStudentByName(@PathVariable String name, @RequestBody Student student) {
        return studentService.updateStudentByName(name, student);
    }

    @DeleteMapping("/delete-student-by-id/{id}")
    @ResponseBody
    public String deleteStudentById(@PathVariable long id) {
        return studentService.deleteStudentById(id);
    }

}
