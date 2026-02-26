package com.example.crf.dto;

import com.example.crf.entity.VitalSign;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class VisitResponseDTO {
    private Long id;

    private String name;
    private LocalDate date;

    private VitalSignResponseDTO vitalSign;
}
