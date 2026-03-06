package com.example.crf.mapper;

import com.example.crf.dto.PatientRequestDTO;
import com.example.crf.dto.PatientResponseDTO;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Study;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientResponseDTO toResponseDTO(Patient patient) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId());
        dto.setSubjectNumber(patient.getSubjectNumber());
        if (patient.getStudy() != null) {
            dto.setStudyId(patient.getStudy().getId());
            dto.setStudyName(patient.getStudy().getName());
        }

        return dto;
    }

    public Patient toEntity(PatientRequestDTO dto, Study study) {
        Patient patient = new Patient();
        patient.setSubjectNumber(dto.getSubjectNumber());
        patient.setStudy(study);

        return patient;
    }
}

