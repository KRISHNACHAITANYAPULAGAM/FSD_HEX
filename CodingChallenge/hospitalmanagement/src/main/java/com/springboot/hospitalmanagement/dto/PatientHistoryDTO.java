package com.springboot.hospitalmanagement.dto;

import java.util.List;

public class PatientHistoryDTO {
    private String name;
    private int age;
    private List<MedicalHistoryDTO> medicalHistory;

    public PatientHistoryDTO(String name, int age, List<MedicalHistoryDTO> medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<MedicalHistoryDTO> getMedicalHistory() {
        return medicalHistory;
    }
}
