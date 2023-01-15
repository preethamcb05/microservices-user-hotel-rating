package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entities.User;


public interface UserService {
	
	//Create
	User saveUser(User user);
	
	//list
	List<User> getAllUser();
	
	//get single user
	User getUserById(String userId);

}
