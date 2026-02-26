package com.example.crf.dto;

import com.example.crf.entity.VitalSign;

import java.time.LocalDate;

public class VisitRequestDTO {

    private String name;
    private LocalDate date;

    private VitalSignResponseDTO vitalSign;
}
