package com.example.crf.mapper;

import com.example.crf.dto.VisitRequestDTO;
import com.example.crf.dto.VisitResponseDTO;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Visit;
import com.example.crf.entity.VitalSign;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {

    public VisitResponseDTO toResponseDTO(Visit visit) {
        VisitResponseDTO dto = new VisitResponseDTO();

        dto.setId(visit.getId());
        dto.setName(visit.getName());
        dto.setVisitDate(visit.getVisitDate());

        if (visit.getPatient() != null) {
            dto.setPatientId(visit.getPatient().getId());
            dto.setSubjectNumber(visit.getPatient().getSubjectNumber());
        }

        if (visit.getStudy() != null) {
            dto.setStudyId(visit.getStudy().getId());
        }

        if (visit.getVitalSigns() != null) {
            dto.setVitalSignIds(
                    visit.getVitalSigns()
                            .stream()
                            .map(VitalSign::getId)
                            .toList()
            );
        }

        return dto;
    }

    public Visit toEntity(VisitRequestDTO dto) {
        Visit visit = new Visit();

        visit.setName(dto.getName());
        visit.setVisitDate(dto.getVisitDate());

        return visit;
    }
}

