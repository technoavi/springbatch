package com.narender;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        Reader rd = (Reader) bf.getBean("reader");
        System.out.println(rd.pdfReader("This is a PDF text"));
        System.out.println(rd.wordReader("This is a Word text"));
    }
}
