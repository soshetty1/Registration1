package com.example.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Registration.model.User;
import com.example.Registration.service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	@GetMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId= user.getEmailId();
		if(tempEmailId!= null && !"".equals(tempEmailId)) {
			User userobj= service.fetchUserByEmailId(tempEmailId);
			 if(userobj!= null) {
				 throw new Exception("user with "+tempEmailId+" is already exist");
			 }
			
		}
		User userobj =null;
		userobj= service.saveUser(user);
		return userobj;
		
	}

}
