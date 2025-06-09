package com.springboot.hospitalmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.hospitalmanagement.dto.MedicalHistoryDTO;
import com.springboot.hospitalmanagement.dto.PatientHistoryDTO;
import com.springboot.hospitalmanagement.model.Patient;
import com.springboot.hospitalmanagement.model.User;
import com.springboot.hospitalmanagement.repository.MedicalHistoryRepository;
import com.springboot.hospitalmanagement.repository.PatientRepository;
@Service
public class PatientService {
	
	private PatientRepository patientRepository;
	private UserService userService;
	private MedicalHistoryRepository medicalHistoryRepository;

	public PatientService(PatientRepository patientRepository,UserService userService,MedicalHistoryRepository medicalHistoryRepository) {
		super();
		this.patientRepository = patientRepository;
		this.userService=userService;
		this.medicalHistoryRepository=medicalHistoryRepository;
	}

	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		User user=patient.getUser();
		user.setRole("PATIENT");
		userService.signUp(user);
		patient.setUser(user);
		
		
		if (patient.getMedicalHistory() != null) {
            patient.getMedicalHistory().forEach(mh -> mh.setPatient(patient));
        }
		return patientRepository.save(patient);
	}
	
	public PatientHistoryDTO getPatientWithHistory(int patientId) {
	    Patient patient = patientRepository.findById(patientId)
	        .orElseThrow(() -> new RuntimeException("Patient not found"));

	    List<MedicalHistoryDTO> historyDTOs = patient.getMedicalHistory().stream()
	        .map(m -> new MedicalHistoryDTO(m.getIllness(), m.getNum_of_years(), m.getCurrent_medication()))
	        .toList();

	    return new PatientHistoryDTO(patient.getName(), patient.getAge(), historyDTOs);
	}


}
