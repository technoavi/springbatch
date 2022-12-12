package com.annotation1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = {"Package2"})
public class myConfig {

    @Bean("student0")
    @Lazy
    public Student getStudent() {
//        System.out.println("student0");
        return new Student("student-0");
    }

    @Bean("student1")
    @Lazy
    public Student getStudent1() {
//        System.out.println("student1");
        return new Student("student-1");
    }

    @Bean
    public Date getDate() {
        return new Date();
    }
}
