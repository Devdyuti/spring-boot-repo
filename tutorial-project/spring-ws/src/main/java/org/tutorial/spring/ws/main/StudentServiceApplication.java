package org.tutorial.spring.ws.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tutorial.spring.ws.controller.StudentController;

@SpringBootApplication
public class StudentServiceApplication {
	
//	@RequestMapping("/")
//	String hello() {
//		return "hello";
//	}

	public static void main(String[] args) {
		SpringApplication.run(StudentController.class, args);
	}

}
