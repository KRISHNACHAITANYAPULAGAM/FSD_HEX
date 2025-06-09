package com.springboot.hospitalmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospitalmanagement.dto.PatientHistoryDTO;
import com.springboot.hospitalmanagement.model.Patient;
import com.springboot.hospitalmanagement.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	/*
	 * requires : patient body with (or) without Medical condition
	 * uses: @RequestBody
	 * returns:Patient
	 * method:Post
	 * access:every one
	 * */
	
	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	/*
	 *method:get
	 *requres:PatientHistoryDtoid
	 *returns:patientHistoryDto with only patient and Illness,number of years,medication
	 * Access:only logged in users
	 * */
	
	@GetMapping("/history/{id}")
	public PatientHistoryDTO getPatientWithHistory(@PathVariable int id) {
	    return patientService.getPatientWithHistory(id);
	}

}
