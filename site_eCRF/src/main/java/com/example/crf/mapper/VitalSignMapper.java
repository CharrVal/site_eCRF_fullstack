package com.example.crf.mapper;

import com.example.crf.dto.VitalSignRequestDTO;
import com.example.crf.dto.VitalSignResponseDTO;
import com.example.crf.entity.Visit;
import com.example.crf.entity.VitalSign;
import org.springframework.stereotype.Component;

@Component
public class VitalSignMapper {

    public VitalSignResponseDTO toResponseDTO(VitalSign vitalSign) {
        VitalSignResponseDTO dto = new VitalSignResponseDTO();
        dto.setId(vitalSign.getId());
        dto.setType(vitalSign.getType());
        dto.setValue(vitalSign.getValue());
        dto.setUnit(vitalSign.getUnit());
        dto.setMeasuredAt(vitalSign.getMeasuredAt());
        dto.setVisitId(vitalSign.getVisit().getId());

        return dto;
    }

    public VitalSign toEntity(VitalSignRequestDTO dto, Visit visit) {
        VitalSign vitalSign = new VitalSign();
        vitalSign.setType(dto.getType());
        vitalSign.setValue(dto.getValue());
        vitalSign.setUnit(dto.getUnit());
        vitalSign.setMeasuredAt(dto.getMeasuredAt());
        vitalSign.setVisit(visit);

        return vitalSign;
    }
}

