package com.controller;

import com.pojo.College;
import com.pojo.Student;
import com.service.StudentCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard") // localhost:8080/dashboard/get-student-by-id/1
public class ControllerClass {
    @Autowired
    StudentCollegeService studentCollegeService;

    @PostMapping("/create-student")
    @ResponseBody
    public Student createStudent(@RequestBody Student student) {
        return studentCollegeService.createStudent(student);
    }

    @GetMapping("/get-student-json")
    @ResponseBody
    public Student getStudentJSON() {
        return new Student();
    }

    @GetMapping("/get-all-student")
    @ResponseBody
    public List<Student> getAllStudent() {
        return studentCollegeService.getAllStudent();
    }

    @GetMapping("/get-student-by-name/{name}")
    @ResponseBody
    public Student getStudentByName(@PathVariable("name") String name) {
        return studentCollegeService.getStudentByName(name);
    }

    @GetMapping("/get-student-by-id/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable("id") long id) {
        return studentCollegeService.getStudentById(id);
    }

    @ResponseBody
    @PutMapping("/update-student-by-id/{id}")
    public Student updateStudentById(@PathVariable("id") long id, @RequestBody Student student) {
        return studentCollegeService.updateStudentById(id, student);
    }

    @ResponseBody
    @PutMapping("/update-student-by-name/{name}")
    public Student updateStudentByName(@PathVariable String name, @RequestBody Student student) {
        return studentCollegeService.updateStudentByName(name, student);
    }

    @DeleteMapping("/delete-student-by-id/{id}")
    @ResponseBody
    public String deleteStudentById(@PathVariable long id) {
        return studentCollegeService.deleteStudent(id);
    }
// -------------------------------------College-----------------------------------
    @PostMapping("/create-college")
    @ResponseBody
    public College createCollege(@RequestBody College college) {
        return studentCollegeService.createCollege(college);
    }

    @GetMapping("/get-college-json")
    @ResponseBody
    public College getCollegeJSON() {
        return new College();
    }

    @GetMapping("/get-all-college")
    @ResponseBody
    public List<College> getAllCollege() {
        return studentCollegeService.getAllCollege();
    }

    @PutMapping("/update-college-by-name/{name}")
    @ResponseBody
    public College updateCollegeByName(@PathVariable String name, @RequestBody College college) {
        return studentCollegeService.updateCollegeByName(name, college);
    }

    @GetMapping("/get-college-by-name/{name}")
    @ResponseBody
    public College getCollegeByName(@PathVariable String name) {
        return studentCollegeService.getCollegeByName(name);
    }

    @DeleteMapping("/delete-college-by-name/{name}")
    @ResponseBody
    public String deleteCollegeByName(@PathVariable String name) {
        return studentCollegeService.deleteCollegeByName(name);
    }
}
