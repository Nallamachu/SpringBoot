package com.company.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootToDoApplication.class, args);
	}

}
