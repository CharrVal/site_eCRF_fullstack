package com.example.crf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VisitResponseDTO {
    private Long id;

    private String name;
    private LocalDate date;

    private VitalSignResponseDTO vitalSign;
}
