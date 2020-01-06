package com.store.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.store.main.model.Users;
import com.store.main.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(method = RequestMethod.POST , value = "/users")
	public void addUsers(@RequestBody Users user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/users/{username}")
	public void deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
	}

}
