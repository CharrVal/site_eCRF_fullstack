package com.example.crf.mapper;

import com.example.crf.dto.PatientRequestDTO;
import com.example.crf.dto.PatientResponseDTO;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Site;
import com.example.crf.entity.Visit;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientResponseDTO toResponseDTO(Patient patient) {

        PatientResponseDTO dto = new PatientResponseDTO();

        dto.setId(patient.getId());
        dto.setSubjectNumber(patient.getSubjectNumber());

        if (patient.getSite() != null) {
            dto.setSiteId(patient.getSite().getId());
        }

        if (patient.getVisits() != null) {
            dto.setVisitIds(
                    patient.getVisits()
                            .stream()
                            .map(Visit::getId)
                            .toList()
            );
        }

        return dto;
    }

    public Patient toEntity(PatientRequestDTO dto, Site site) {

        Patient patient = new Patient();

        patient.setSubjectNumber(dto.getSubjectNumber());
        patient.setSite(site);

        return patient;
    }
}


