package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired
	 UserService userService;
	
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
	  User persistedObject = userService.createNewUser(user);
	  return new ResponseEntity<>(persistedObject,HttpStatus.OK);
	  
	  
	}
}

	
