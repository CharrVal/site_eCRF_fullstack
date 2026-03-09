package com.example.crf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SiteResponseDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long studyId;
    private List<Long> patientIds;
}
