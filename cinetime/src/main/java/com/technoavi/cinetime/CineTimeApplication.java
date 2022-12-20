package com.technoavi.cinetime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.technoavi.cinetime.*")
public class CineTimeApplication {

	public static void main(String[] args) {

		SpringApplication.run(CineTimeApplication.class, args);
	}

}
