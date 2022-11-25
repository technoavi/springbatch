package com.technoavi.medico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MedicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicoApplication.class, args);

		System.out.println("hello");
	}

}
