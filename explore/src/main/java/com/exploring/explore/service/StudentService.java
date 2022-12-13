package com.exploring.explore.service;

import com.exploring.explore.dao.StudentRepository;
import com.exploring.explore.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {
    private Map<Integer, Student> map = new HashMap<>();
    Integer key = 0;
    @Autowired
    StudentRepository studentRepository;
    public String createStudentOfTabel(Student s) {
        Student newStudent = new Student();
        newStudent.setId(s.getId());
        newStudent.setName(s.getName());
        newStudent.setRollNo(s.getRollNo());
//        map.put(key++, newStudent);

        studentRepository.save(newStudent);
        return "created";
    }

    public List<Student> getAllStudent() {
//        return this.map;
        return studentRepository.findAll();
    }

    public String updateStudent(Long id, Student s) {
//        int key = Integer.MAX_VALUE;

//        for(Map.Entry<Integer, Student> entry : map.entrySet()) {
//            if(entry.getValue().getId() == s.getId()) {
//                key = entry.getKey();
//            }
//        }
//
//        map.get(key).setName(s.getName());
//        map.get(key).setRollNo(s.getRollNo());
//
//        return "updated student information : " + map.get(key).toString();

        Optional<Student> optional = studentRepository.findById(id);
        Student st = optional.get();
        st.setName(s.getName());
        st.setRollNo(s.getRollNo());
        studentRepository.save(st);
        return "updated!!";
    }

    public String deleteStudent(Long id) {
//        int key = Integer.MAX_VALUE;
//
//        for(Map.Entry<Integer, Student> entry : map.entrySet()) {
//            if(entry.getValue().getName() == name) {
//                key = entry.getKey();
//            }
//        }
//        map.remove(key);
        studentRepository.deleteById(id);

        return "deleted";
    }

}
