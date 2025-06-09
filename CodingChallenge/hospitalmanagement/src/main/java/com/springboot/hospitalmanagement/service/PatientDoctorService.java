package com.springboot.hospitalmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.hospitalmanagement.model.Doctor;
import com.springboot.hospitalmanagement.model.Patient;
import com.springboot.hospitalmanagement.model.PatientDoctor;
import com.springboot.hospitalmanagement.repository.DoctorRepository;
import com.springboot.hospitalmanagement.repository.PatientDoctorRepository;
import com.springboot.hospitalmanagement.repository.PatientRepository;
@Service
public class PatientDoctorService {
	
	private DoctorRepository doctorRepository;
	private PatientDoctorRepository patientDoctorRepository;
	private PatientRepository patientRepository;
	
	

	public PatientDoctorService(DoctorRepository doctorRepository, PatientDoctorRepository patientDoctorRepository,
			PatientRepository patientRepository) {
		super();
		this.doctorRepository = doctorRepository;
		this.patientDoctorRepository = patientDoctorRepository;
		this.patientRepository = patientRepository;
	}



	public PatientDoctor makeAppointment(int patientId, int doctorId) {
		// TODO Auto-generated method stub
		
		Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        
        PatientDoctor appointment=new PatientDoctor();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentTime(java.time.LocalDateTime.now());
        

		return patientDoctorRepository.save(appointment);
	}
	

	public List<PatientDoctor> getPatientsByDoctorId(int doctorId) {
		
        return patientDoctorRepository.findByDoctorId(doctorId);
    }

}
