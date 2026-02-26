package com.example.crf.dto;

import com.example.crf.entity.Visit;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientRequestDTO {

    private Integer subjectNumber;

    private List<VisitResponseDTO> visitIds;
}
