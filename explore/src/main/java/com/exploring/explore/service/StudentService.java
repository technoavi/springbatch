package com.exploring.explore.service;

import com.exploring.explore.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private Map<Integer, Student> map = new HashMap<>();
    Integer key = 0;

    public String createStudentOfTabel(Student s) {
        Student newStudent = new Student();
        newStudent.setId(s.getId());
        newStudent.setName(s.getName());
        newStudent.setRollNo(s.getRollNo());
        map.put(key++, newStudent);
        return "Successfully created student having\n" + newStudent.toString();
    }

    public Map<Integer, Student> getAllStudent() {
        return this.map;
    }

    public String updateStudent(Student s) {
        int key = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Student> entry : map.entrySet()) {
            if(entry.getValue().getId() == s.getId()) {
                key = entry.getKey();
            }
        }

        map.get(key).setName(s.getName());
        map.get(key).setRollNo(s.getRollNo());

        return "updated student information : " + map.get(key).toString();
    }

    public String deleteStudent(String name) {
        int key = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Student> entry : map.entrySet()) {
            if(entry.getValue().getName() == name) {
                key = entry.getKey();
            }
        }
        map.remove(key);

        return "Successfully deleted " + name;
    }

}
