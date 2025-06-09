package com.springboot.hospitalmanagement.service;

import org.springframework.stereotype.Service;

import com.springboot.hospitalmanagement.model.Doctor;
import com.springboot.hospitalmanagement.model.User;
import com.springboot.hospitalmanagement.repository.DoctorRepository;

@Service
public class DoctorService {
	
	private DoctorRepository doctorRepository;
	private UserService userService;

	

	public DoctorService(DoctorRepository doctorRepository, UserService userService) {
		super();
		this.doctorRepository = doctorRepository;
		this.userService = userService;
	}



	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		User user=doctor.getUser();
		user.setRole("DOCTOR");
		userService.signUp(user);
		doctor.setUser(user);
		
		
		return doctorRepository.save(doctor);
	}

}
