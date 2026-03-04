package com.example.crf.mapper;

import com.example.crf.dto.VitalSignRequestDTO;
import com.example.crf.dto.VitalSignResponseDTO;
import com.example.crf.entity.VitalSign;
import org.springframework.stereotype.Component;

@Component
public class VitalSignMapper {

    public VitalSign toEntity(VitalSignRequestDTO dto) {
        VitalSign vitalSign = new VitalSign();
        vitalSign.setType(dto.getType());
        vitalSign.setValue(dto.getValue());
        vitalSign.setUnit(dto.getUnit());
        vitalSign.setMeasuredAt(dto.getMeasuredAt());
        return vitalSign;
    }

    public VitalSignResponseDTO toResponse(VitalSign vitalSign) {
        VitalSignResponseDTO dto = new VitalSignResponseDTO();
        dto.setId(vitalSign.getId());
        dto.setType(vitalSign.getType());
        dto.setValue(vitalSign.getValue());
        dto.setUnit(vitalSign.getUnit());
        dto.setMeasuredAt(vitalSign.getMeasuredAt());
        return dto;
    }
}

