package com.example.crf.service;

import com.example.crf.dto.VisitRequestDTO;
import com.example.crf.dto.VisitResponseDTO;

import java.util.List;

public interface VisitService {
    VisitResponseDTO findById(Long id);
    List<VisitResponseDTO> findAll();
    List<VisitResponseDTO> findByPatient(Long patientId);
    VisitResponseDTO createVisit(VisitRequestDTO dto);
    VisitResponseDTO updateVisit(Long id, VisitRequestDTO dto);
    void deleteVisit(Long id);
}
