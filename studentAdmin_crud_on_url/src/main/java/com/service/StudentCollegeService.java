package com.service;

import com.pojo.College;
import com.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StudentCollegeService {
    private List<Student> studentList = new ArrayList<>();
    private List<College> collegeList = new ArrayList<>();
    Random r = new Random();
    private Student copyStudent(Student oldStudent, Student newStudent) {
        oldStudent.setName(newStudent.getName());
        oldStudent.setId(newStudent.getId());
        oldStudent.setRollNo(newStudent.getRollNo());
        oldStudent.setStream(newStudent.getStream());
        oldStudent.setCurrentSemester(newStudent.getCurrentSemester());
        oldStudent.setCollege(newStudent.getCollege());

        return oldStudent;
    }

    public Student createStudent(Student student) {
        Student newStudent = new Student(student);
        newStudent.setId((long)r.nextInt(5000));
        studentList.add(newStudent);
        return newStudent;
    }

    public List<Student> getAllStudent() {
        return studentList;
    }

    public Student getStudentById(long id) {
        for (Student student : studentList) {
            if(student.getId() == id) {
                return student;
            }
        }
        return new Student();
    }

    public Student getStudentByName(String name) {
        for (Student student : studentList) {
            if(student.getName().equals(name)) {
//                System.out.println("Student found!!");
                return student;
            }
        }
        return null;
    }

    public Student updateStudentById(long id, Student student) {
        for (Student oldStudent : studentList) {
            if(oldStudent.getId() == id) {
                return copyStudent(oldStudent, student);
            }
        }
        return null;
    }

    public Student updateStudentByName(String name, Student student) {
        for (Student oldStudent : studentList) {
            if(oldStudent.getName().equals(name)) {
                return copyStudent(oldStudent, student);
            }
        }
        return null;
    }

    public String deleteStudent(long id) {
        for (Student student : studentList) {
            if(student.getId() == id) {
                studentList.remove(student);
                return "Deleted";
            }
        }
        return "Id not found Deleted";
    }
//-----------------------------------College-----------------------------------
    private College copyCollege(College oldCollege, College newCollege) {
        oldCollege.setName(newCollege.getName());
        oldCollege.setDegreeType(newCollege.getDegreeType());
        oldCollege.setAddress(newCollege.getAddress());
        oldCollege.setMaxStudent(newCollege.getMaxStudent());
        return oldCollege;
    }

    public College createCollege(College college) {
        College newCollege = new College(college);
        collegeList.add(newCollege);
        return newCollege;
    }

    public List<College> getAllCollege() {
        return collegeList;
    }

    public College getCollegeByName(String name) {
        for(College college : collegeList) {
            if(college.getName().equals(name)) {
                return college;
            }
        }
        return null;
    }

    public College updateCollegeByName(String name, College oldCollege) {
        for(College college : collegeList) {
            if(college.getName().equals(name)) {
                return copyCollege(college, oldCollege);
            }
        }
        return null;
    }

    public String deleteCollegeByName(String name) {
        for(College college : collegeList) {
            if(college.getName().equals(name)) {
                collegeList.remove(college);
                return name + " college has been deleted.";
            }
        }

        return name + " college not found.";
    }
}
