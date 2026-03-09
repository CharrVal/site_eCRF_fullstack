package com.example.crf.service;

import com.example.crf.dto.VitalSignRequestDTO;
import com.example.crf.dto.VitalSignResponseDTO;

import java.util.List;

public interface VitalSignService {
    VitalSignResponseDTO findById(Long id);
    List<VitalSignResponseDTO> findAll();
    List<VitalSignResponseDTO> findByVisit(Long visitId);
    VitalSignResponseDTO createVitalSign(VitalSignRequestDTO dto);
    VitalSignResponseDTO updateVitalSign(Long id, VitalSignRequestDTO dto);
    void deleteVitalSign(Long id);
}