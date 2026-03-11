package com.example.crf.service;

import com.example.crf.dto.VisitRequestDTO;
import com.example.crf.dto.VisitResponseDTO;
import com.example.crf.entity.Visit;

import java.util.List;

public interface VisitService {
    VisitResponseDTO findById(Long id);
    List<VisitResponseDTO> findAll();
    List<VisitResponseDTO> findByPatient(Long patientId);
    List<VisitResponseDTO> findByStudy(Long studyId);
    VisitResponseDTO createVisit(VisitRequestDTO dto);
    VisitResponseDTO updateVisit(Long id, VisitRequestDTO dto);
    void deleteVisit(Long id);
}
