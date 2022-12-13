package com.exploring.explore.controllars;

import com.exploring.explore.model.Student;
import com.exploring.explore.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

//    @PostMapping("/create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public Student createStudent(@RequestBody Student student) {//
        studentService.createStudentOfTabel(student);
//        System.out.println("Student Created");
        return new Student();
    }
//    @GetMapping("/get")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Map<Integer, Student> getAllStudent() {
        return studentService.getAllStudent();
    }

//    @PutMapping("/update")
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public String updateStudent(@RequestBody Student s) {
        studentService.updateStudent(s);
        return "Student Updated";
    }

//    @DeleteMapping("/delete")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String deleteStudent(@RequestBody String name) {
        studentService.deleteStudent(name);

        return "Student Deleted";
    }

}
