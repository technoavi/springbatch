package com.project1;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Test {

	public static void main(String[] args) {
//		Annotation
//		JavaConfig
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		Employee obj = (Employee)app.getBean("emp");
		obj.print();

		
//		BeanFactory bFac = new XmlBeanFactory(new ClassPathResource("applicationContext.xml")); //it is working only for setter injuction
		BeanFactory bFac = new ClassPathXmlApplicationContext("applicationContext.xml");//for both setter and constructor injuction
		Employee obj1 = (Employee)bFac.getBean("emp");
		obj1.print();
	}

}
