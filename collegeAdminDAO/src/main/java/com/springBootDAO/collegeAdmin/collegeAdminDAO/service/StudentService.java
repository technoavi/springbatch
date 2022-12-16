package com.springBootDAO.collegeAdmin.collegeAdminDAO.service;

import com.springBootDAO.collegeAdmin.collegeAdminDAO.DAO.StudentRepository;
import com.springBootDAO.collegeAdmin.collegeAdminDAO.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    private List<Student> studentList = new ArrayList<>();
    Random r = new Random();
    private Student copyStudent(Student oldStudent, Student newStudent) {
        oldStudent.setName(newStudent.getName());
//        oldStudent.setId(newStudent.getId());
        oldStudent.setRollNo(newStudent.getRollNo());
        oldStudent.setStream(newStudent.getStream());
        oldStudent.setCurrentSemester(newStudent.getCurrentSemester());
        oldStudent.setCollege(newStudent.getCollege());

        return oldStudent;
    }

    public Student createStudent(Student student) {
        Student newStudent = new Student(student);
        return studentRepository.save(newStudent);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public Student getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    public Student updateStudentById(long id, Student student) {
        Optional<Student> oldStudent = studentRepository.findById(id);
        return studentRepository.save(copyStudent(oldStudent.get(), student));
    }

    public Student updateStudentByName(String name, Student student) {
        Student oldStudent = studentRepository.getStudentByName(name);
        return studentRepository.save(copyStudent(oldStudent, student));
    }

    public String deleteStudentById(long id) {
        studentRepository.deleteById(id);
        return "deleted";
    }
}
