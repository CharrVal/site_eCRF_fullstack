package com.example.crf.mapper;

import com.example.crf.dto.PatientRequestDTO;
import com.example.crf.dto.PatientResponseDTO;
import com.example.crf.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(PatientRequestDTO dto) {
        Patient patient = new Patient();
        patient.setSubjectNumber(dto.getSubjectNumber());
        return patient;
    }

    public PatientResponseDTO toResponse(Patient patient) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId());
        dto.setSubjectNumber(patient.getSubjectNumber());
        return dto;
    }
}

