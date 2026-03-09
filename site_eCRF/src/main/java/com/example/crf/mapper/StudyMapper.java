package com.example.crf.mapper;

import com.example.crf.dto.*;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Site;
import com.example.crf.entity.Study;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudyMapper {

    public StudyResponseDTO toResponseDTO(Study study) {
        StudyResponseDTO dto = new StudyResponseDTO();

        dto.setId(study.getId());
        dto.setName(study.getName());
        dto.setDescription(study.getDescription());

        if (study.getSites() != null) {
            dto.setSiteIds(
                    study.getSites()
                            .stream()
                            .map(Site::getId)
                            .toList()
            );
        }

        return dto;
    }

    public Study toEntity(StudyRequestDTO dto) {
        Study study = new Study();

        study.setName(dto.getName());
        study.setDescription(dto.getDescription());

        return study;
    }
}


