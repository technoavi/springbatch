package com.exploring.explore.controllars;

import com.exploring.explore.model.Student;
import com.exploring.explore.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

//    @PostMapping("/create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public void createStudent(@RequestBody Student student) {
        studentService.createStudentOfTabel(student);
        System.out.println("Student Created");
    }
//    @GetMapping("/get")
//    public Map<Integer, Student> getAllStudent() {
//        return studentService.getAllStudent();
//    }
//
//    @PutMapping("/update")
//    public String updateStudent(Student s) {
//        studentService.updateStudent(s);
//        return "Student Updated";
//    }
//
//    @DeleteMapping("/delete")
//    public String deleteStudent(String name) {
//        studentService.deleteStudent(name);
//
//        return "Student Deleted";
//    }

}
