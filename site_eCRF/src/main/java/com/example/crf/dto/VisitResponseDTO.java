package com.example.crf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class VisitResponseDTO {

    private Long id;
    private String name;
    private LocalDate visitDate;
    private Long patientId;
    private Integer subjectNumber;
    private List<Long> vitalSignIds;
}
