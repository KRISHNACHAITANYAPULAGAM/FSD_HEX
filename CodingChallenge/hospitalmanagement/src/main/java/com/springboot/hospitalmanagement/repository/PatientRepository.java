package com.springboot.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospitalmanagement.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
