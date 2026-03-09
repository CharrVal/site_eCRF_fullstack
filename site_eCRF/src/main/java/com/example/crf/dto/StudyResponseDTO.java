package com.example.crf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudyResponseDTO {

    private Long id;
    private String name;
    private String description;
    private Long userId;
    private List<Long> siteIds;
}
