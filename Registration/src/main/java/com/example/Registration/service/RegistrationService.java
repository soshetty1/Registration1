package com.example.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Registration.model.User;
import com.example.Registration.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo;
	public User saveUser(User user) {
		 return repo.save(user);	 
	}
	public User fetchUserByEmailId(String email) {
		 return repo.findByEmailId(email);
	}
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		 return repo.findUserByEmailIdAndPassword(email, password);

}
}
