package com.narender;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        //BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student st1 = (Student)ac.getBean("stu");
        System.out.println(st1.getName());
    }
}
