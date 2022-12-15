package com.pojo;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private long id;
    private int rollNo;
    private int currentSemester;
    private String stream;

    private String college;

    public Student() {
    }

    public Student(Student student) {
        this.name = student.name;
        this.id = student.id;
        this.rollNo = student.rollNo;
        this.currentSemester = student.currentSemester;
        this.stream = student.stream;
        this.college = student.college;
    }

    @Override
    public String toString() {
        return "StudentPojo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", rollNo=" + rollNo +
                ", currentSemester=" + currentSemester +
                ", stream='" + stream + '\'' +
                ", college='" + college + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
