package com.example.crf.dto;

import com.example.crf.entity.Patient;

import java.util.List;

public class StudyRequestDTO {
    private String name;

    private String description;

    private List<PatientResponseDTO> patients;
}
