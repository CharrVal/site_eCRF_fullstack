package com.example.crf.service;

import com.example.crf.dto.StudyRequestDTO;
import com.example.crf.dto.StudyResponseDTO;
import com.example.crf.entity.Study;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudyService {
    StudyResponseDTO findById(Long id);
    List<StudyResponseDTO> findAll();
    StudyResponseDTO createStudy(StudyRequestDTO dto);
    StudyResponseDTO updateStudy(Long id, StudyRequestDTO dto);
    void deleteStudy(Long id);
}
