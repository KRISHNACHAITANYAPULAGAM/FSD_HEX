package com.springboot.hospitalmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.hospitalmanagement.enums.Speciality;
import com.springboot.hospitalmanagement.model.Doctor;
import com.springboot.hospitalmanagement.model.Patient;
import com.springboot.hospitalmanagement.model.PatientDoctor;
import com.springboot.hospitalmanagement.repository.DoctorRepository;
import com.springboot.hospitalmanagement.repository.PatientDoctorRepository;
import com.springboot.hospitalmanagement.repository.PatientRepository;
import com.springboot.hospitalmanagement.service.PatientDoctorService;

@SpringBootTest
public class GetPatientsDoctorIdTest {
	
	@InjectMocks
	private PatientDoctorService patientDoctorService;
	@Mock
	private PatientRepository patientRepository;
	@Mock
	private DoctorRepository doctorRepository;
	@Mock
	private PatientDoctorRepository patientDoctorRepository;
	
	private Patient patient;
	private Doctor doctor;
	private PatientDoctor appointment;
	@BeforeEach
	public void init() {
		patient=new Patient();
		patient.setId(1);
		patient.setName("Lloyd");
		patient.setAge(40);

		doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("Dr. Strange");
        doctor.setSpeciality(Speciality.CARDIO);

        appointment = new PatientDoctor();
        appointment.setId(1);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentTime(LocalDateTime.now());

		
	}
	@Test
	public void testGetPatientsByDoctorId() {
		
		when(patientDoctorRepository.findByDoctorId(1)).thenReturn(List.of(appointment));
		
		List<PatientDoctor> resultlist=patientDoctorService.getPatientsByDoctorId(1);
		
		assertEquals(List.of(appointment), resultlist);
		
		
	}

}


