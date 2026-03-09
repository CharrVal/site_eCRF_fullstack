package com.example.crf.mapper;

import com.example.crf.dto.SiteRequestDTO;
import com.example.crf.dto.SiteResponseDTO;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Site;
import org.springframework.stereotype.Component;

@Component
public class SiteMapper {

    public SiteResponseDTO toResponseDto(Site site) {
        SiteResponseDTO dto = new SiteResponseDTO();

        dto.setId(site.getId());
        dto.setName(site.getName());
        dto.setStartDate(site.getStartDate());
        dto.setEndDate(site.getEndDate());

        if (site.getStudy() != null) {
            dto.setStudyId(site.getStudy().getId());
        }

        if (site.getPatients() != null) {
            dto.setPatientIds(
                    site.getPatients()
                            .stream()
                            .map(Patient::getId)
                            .toList()
            );
        }

        return dto;
    }

    public Site toEntity(SiteRequestDTO dto) {
        Site site = new Site();

        site.setName(dto.getName());
        site.setStartDate(dto.getStartDate());
        site.setEndDate(dto.getEndDate());

        return site;
    }
}
