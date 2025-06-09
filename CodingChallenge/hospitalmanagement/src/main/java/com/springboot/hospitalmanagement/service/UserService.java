package com.springboot.hospitalmanagement.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.hospitalmanagement.model.User;
import com.springboot.hospitalmanagement.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	

	public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder=passwordEncoder;
		
	}
/*
 * method: signup
 * return :user
 * can be used to automate username password while adding new doctor or patient
 * 
 * */


	public User signUp(User user) {
		// TODO Auto-generated method stub
		String password=user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		
		return userRepository.save(user);
	}
	
	

}
