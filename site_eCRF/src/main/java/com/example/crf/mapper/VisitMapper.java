package com.example.crf.mapper;

import com.example.crf.dto.VisitRequestDTO;
import com.example.crf.dto.VisitResponseDTO;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Visit;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {

    public VisitResponseDTO toResponseDTO(Visit visit) {
        VisitResponseDTO dto = new VisitResponseDTO();

        dto.setId(visit.getId());
        dto.setName(visit.getName());
        dto.setVisitDate(visit.getVisitDate());
        dto.setPatientId(visit.getPatient().getId());
        dto.setSubjectNumber(visit.getPatient().getSubjectNumber());

        return dto;
    }

    public Visit toEntity(VisitRequestDTO dto, Patient patient) {
        Visit visit = new Visit();

        visit.setName(dto.getName());
        visit.setVisitDate(dto.getVisitDate());
        visit.setPatient(patient);

        return visit;
    }
}

