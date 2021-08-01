package com.sourav.rma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.rma.dto.UserDto;
import com.sourav.rma.entity.Role;
import com.sourav.rma.entity.User;
import com.sourav.rma.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment env; 
	
	@GetMapping("/status")
	public String statusCheck() {
		return "Working on port : " + env.getProperty("server.port");
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
				 produces = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody UserDto userDto) {
		return userService.createUser(userDto);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers() {
		return userService.getAllUser();
	}
	
	@GetMapping(path = "/{id}", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable long id) {
		return userService.getUser(id);
	}
	
	@PutMapping(path = "/{id}", 
				consumes = MediaType.APPLICATION_JSON_VALUE,
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@PathVariable long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@PutMapping(path = "/{userId}/assignproductowner") 
	public void assignProductOwner(@PathVariable String userId) {
		userService.assignProductOwner(userId);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteProduct(@PathVariable long id) {
		userService.deleteUserById(id);
	}

}
