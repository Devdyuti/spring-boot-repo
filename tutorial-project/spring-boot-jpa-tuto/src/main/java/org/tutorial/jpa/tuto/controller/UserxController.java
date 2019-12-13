package org.tutorial.jpa.tuto.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tutorial.jpa.tuto.entity.Userx;
import org.tutorial.jpa.tuto.service.UserxService;

@RestController
@RequestMapping(value="/user")
public class UserxController {
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserxController.class);
	
	@Autowired
	private UserxService userService;
	
	@RequestMapping(value="/checkStatus", method=RequestMethod.HEAD)
	public void checkServiceavailablity(HttpServletResponse response) throws IOException {
		response.setHeader("Custom-Header", "User-service");
		response.setHeader("Status", "Ok");
		response.getWriter().println("User-service is up and Running!");
	} 
	
	@PostMapping("/add")
	public Userx insertUser(@RequestBody Userx user) {
		try {
			return userService.addUser(user);
		}catch (Exception e) {
			LOGGER.error("EXCEPTION IN USERCONTROLLER"+e.getMessage());
		}
		return null;
	}

}
