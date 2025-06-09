package com.springboot.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospitalmanagement.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
