package com.example.crf.dto;

import com.example.crf.entity.Patient;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudyResponseDTO {
    private Long id;

    private String name;

    private String description;

    private List<Long> patientIds;
}
