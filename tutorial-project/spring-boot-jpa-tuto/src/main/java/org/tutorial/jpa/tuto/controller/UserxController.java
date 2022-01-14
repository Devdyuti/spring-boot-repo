package org.tutorial.jpa.tuto.controller;



import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tutorial.jpa.tuto.entity.Userx;
import org.tutorial.jpa.tuto.exception.ApplicationException;
//import org.tutorial.jpa.tuto.exception.RecordNotFoundException;
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
		return userService.addUser(user);
	}
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public List<Userx> findAll(){
		return userService.allUser();
	}
	@RequestMapping(value="/findAllx", method=RequestMethod.GET, produces="application/xml")
	public ResponseEntity<List<Userx>> findAllUsers(){
		final HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_XML);
		header.add("Status", "OK");
		List<Userx> users=userService.allUser();
		return new ResponseEntity<List<Userx>>(users,header, HttpStatus.OK);
		
	}
	@RequestMapping(value="/findUserById/{id}", method = RequestMethod.GET)
	public Optional<Userx> findUserById(@PathVariable int id) throws Exception {
		Optional<Userx> user=userService.findUser(id);
		if(user.isPresent())
			return user;
		else
			throw new ApplicationException(203, "Record not found for this given id");
	}

}
