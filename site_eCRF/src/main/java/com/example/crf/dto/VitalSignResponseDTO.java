package com.example.crf.dto;

import com.example.crf.entity.VitalSignType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VitalSignResponseDTO {

    private Long id;
    private VitalSignType type;
    private Double value;
    private String unit;
    private LocalDateTime measuredAt;
    private Long visitId;
}
