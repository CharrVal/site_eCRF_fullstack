package com.example.crf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientRequestDTO {

    private Integer subjectNumber;

    private List<VisitResponseDTO> visitIds;
}
