package com.springboot.hospitalmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.hospitalmanagement.model.PatientDoctor;

public interface PatientDoctorRepository extends JpaRepository<PatientDoctor, Integer>{

//	@Query("SELECT pd.patient FROM PatientDoctor pd WHERE pd.doctor.id = ?1")
	/*
	 * query can give list of patient s so a small change of LisT<Patient> 
	 * */
	List<PatientDoctor> findByDoctorId(int doctorId);
	
	

}
