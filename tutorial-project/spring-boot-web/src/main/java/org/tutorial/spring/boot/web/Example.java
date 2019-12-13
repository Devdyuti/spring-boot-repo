package org.tutorial.spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Configuration
@ComponentScan("org.dev.sp.tu")
public class Example {
	@Autowired
	private Test test;
	
	@RequestMapping(method=RequestMethod.GET, path="/")
	String home() {
		return "Hello World *";
	}
	@RequestMapping("/test")
	String test() {
		return "just checking";
	}
	@RequestMapping("/check")
	String check(String message) {
		return "This is the Message: "+message;
	}
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Example.class, args);
	}
	
}
