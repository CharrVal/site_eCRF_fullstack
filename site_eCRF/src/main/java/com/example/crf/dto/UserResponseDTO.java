package com.example.crf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String username;
    private String roleName;
    private List<Long> studyIds;
}