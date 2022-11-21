package com.technoavi.fisheriz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableAutoConfiguration
public class FisherizApplication {

	public static void main(String[] args) {

		SpringApplication.run(FisherizApplication.class, args);
	}

}
