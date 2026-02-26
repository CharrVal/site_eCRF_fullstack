package com.example.crf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VitalSignResponseDTO {
    private Long id;

    private String name;
    private String description;
    private Double temperature;
    private Integer pulse;
    private Integer systolicPressure;
    private Integer diastolicPressure;
    private Double weight;
    private Double height;
}
