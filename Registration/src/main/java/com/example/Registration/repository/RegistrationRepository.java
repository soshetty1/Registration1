package com.example.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Registration.model.User;

public interface RegistrationRepository extends JpaRepository<User,Integer> {

	public User findByEmailId(String emailid);
	public User findUserByEmailIdAndPassword(String emailid, String password);
}
