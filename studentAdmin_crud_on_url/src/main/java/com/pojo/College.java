package com.pojo;

public class College {
    private String name;
    private String degreeType;
    private int maxStudent;
    private String address;

    public College() {
    }

    public College(College college) {
        this.name = college.name;
        this.degreeType = college.degreeType;
        this.maxStudent = college.maxStudent;
        this.address = college.address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
