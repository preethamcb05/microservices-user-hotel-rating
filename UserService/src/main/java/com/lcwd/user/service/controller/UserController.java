package com.lcwd.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;



@RestController
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	public UserService us;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User u = us.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId)
	{
		User u = us.getUserById(userId);
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers()
	{
		List<User> u = us.getAllUser();
		return ResponseEntity.ok(u);
	}
}
