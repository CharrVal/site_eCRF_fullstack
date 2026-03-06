package com.example.crf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VisitRequestDTO {

    private String name;
    private LocalDate visitDate;
    private Long patientId;
}
