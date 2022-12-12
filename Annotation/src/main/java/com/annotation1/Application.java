package com.annotation1;

import Package2.Package2Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@EnableAutoConfiguration + @ComponentScan + @Configuration
public class Application implements CommandLineRunner {
//    @Autowired
//    @Qualifier("student0")
//    private Student student;
//
//    @Autowired
//    @Qualifier("student1")
//    private Student student1;
//
//    @Autowired
//    private Date date;
//
//    @Autowired
//    private Employee employee;

    @Autowired
    private Package2Class package2Class;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        System.out.println("Hello everyone this is GhostCoder!!");
    }

    @Override
    public void run(String... args) throws Exception {
//        this.student.studying();
//        this.student1.studying();
//        this.date.getDate();
//        this.employee.getName();
//        this.package2Class.getName();
    }
}
