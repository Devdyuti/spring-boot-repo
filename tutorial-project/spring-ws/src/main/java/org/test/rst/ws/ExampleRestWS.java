package org.test.rst.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ExampleRestWS {
	@RequestMapping(method=RequestMethod.GET, path="/checkRest")
	public String checkRest() {
		return "Hello RestWS";
	}
	// Returning a bean
	@GetMapping(path="/checkbean")
	public HelloBean chechBean() {
		return new HelloBean("Hello world");
	}
	@RequestMapping(method=RequestMethod.GET, path="/checkbeanpathvariable/{name}")
	public HelloWorldBean checkHelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World Bean path variable, %s "+name);
	}
	public static void main(String[] args) throws Exception{
		SpringApplication.run(ExampleRestWS.class, args);
	}
}
