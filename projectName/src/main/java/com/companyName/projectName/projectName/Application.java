package com.companyName.projectName.projectName;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //it takes care configuration of all classes and 3rd party jars
public class Application {

	public static void main(String[] args) {//From here only out project will start

		//SpringApplications(class) can read all the beans
		SpringApplication.run(Application.class, args);//run() executes IOC Container
	}

}
