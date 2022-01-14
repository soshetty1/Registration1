package com.example.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Registration.model.User;
import com.example.Registration.service.RegistrationService;

//Rest controller is used because we only need response
@RestController  
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId= user.getEmailId();
		if(tempEmailId!= null && !"".equals(tempEmailId)) {
			User userobj= service.fetchUserByEmailId(tempEmailId);
			 if(userobj!= null) {
				 throw new Exception("user with "+tempEmailId+" is already exist");
			 }
		}
		User userObj =null;
		userObj= service.saveUser(user);
		return userObj;
	}
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String temppass = user.getPassword();
		User userObj= null;
		if(tempEmailId != null && temppass!= null) {
			userObj= service.fetchUserByEmailIdAndPassword(tempEmailId,temppass);
		}
	if(userObj== null) {
		throw new Exception("Bad Credentials");
	}
		return userObj;
	}

}
