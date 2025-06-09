package com.springboot.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospitalmanagement.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer>{

}
