package com.springboot.hospitalmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospitalmanagement.model.PatientDoctor;
import com.springboot.hospitalmanagement.service.PatientDoctorService;

@RestController
@RequestMapping("/api/appointment")
public class PatientDoctorController {
	@Autowired
	private PatientDoctorService patientDoctorService;
	
	/*
	 * method:Post
	 * requires:patientid and doctorid
	 * returns PatientDoctor
	 * used: to resolve many to many by doing many to one and many to one for patient and doctor
	 * access:everyone
	 * */
	
	@PostMapping("/book")
    public PatientDoctor makeAppointment(@RequestParam int patientId, @RequestParam int doctorId) {
        return patientDoctorService.makeAppointment(patientId, doctorId);
    }
	
	
	/*
	 *
	 * requires:doctorId
	 * method:Get
	 * returns : all PatientDoctor in form of list
	 * uses:PathVariable
	 * Access:Only Logged in Doctor
	 * 
	 * */
	@GetMapping("/doctor/{doctorId}")
	public List<PatientDoctor> getPatientsByDoctor(@PathVariable int doctorId){
		return patientDoctorService.getPatientsByDoctorId(doctorId);
	}

}
