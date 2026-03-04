package com.example.crf.mapper;

import com.example.crf.dto.VisitRequestDTO;
import com.example.crf.dto.VisitResponseDTO;
import com.example.crf.entity.Visit;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {

    public Visit toEntity(VisitRequestDTO dto) {
        Visit visit = new Visit();
        visit.setName(dto.getName());
        visit.setVisitDate(dto.getVisitDate());
        return visit;
    }

    public VisitResponseDTO toResponse(Visit visit) {
        VisitResponseDTO dto = new VisitResponseDTO();
        dto.setId(visit.getId());
        dto.setName(visit.getName());
        dto.setVisitDate(visit.getVisitDate());
        return dto;
    }
}

