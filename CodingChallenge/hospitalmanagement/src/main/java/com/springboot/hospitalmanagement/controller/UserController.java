package com.springboot.hospitalmanagement.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospitalmanagement.model.User;
import com.springboot.hospitalmanagement.service.UserService;
import com.springboot.hospitalmanagement.util.JwtUtil;



@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/signup")
	public User signUp(@RequestBody User user) {
		
		return userService.signUp(user);
	}
	/*
	 * use current logged in user to create a token using Principal
	 * method:jwtUtil.createToken()
	 * 
	 * */
	
	@GetMapping("/createToken")
	public String createToken(Principal principal) {
		String token=jwtUtil.createToken(principal.getName());
		return token;
	}

	/*
	 * use this to verify token
	 * method:jwtUtil.verifyToken()
	 * 
	 * */
	@GetMapping("/verifyToken")
	public String verifyValidToken(Principal principal){
		String token=jwtUtil.createToken(principal.getName());
		return jwtUtil.verifyToken(token, principal.getName())?"Token Verifed":"Token NotVerified";
	}
	

}

