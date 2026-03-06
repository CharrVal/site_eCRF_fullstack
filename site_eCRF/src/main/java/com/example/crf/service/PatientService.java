package com.example.crf.service;

import com.example.crf.dto.PatientRequestDTO;
import com.example.crf.dto.PatientResponseDTO;
import com.example.crf.entity.Patient;

import java.util.List;

public interface PatientService {
    PatientResponseDTO findById(Long id);
    List<PatientResponseDTO> findAll();
    List<PatientResponseDTO> findByStudy(Long studyId);
    PatientResponseDTO createPatient(PatientRequestDTO dto);
    PatientResponseDTO updatePatient(Long id, PatientRequestDTO dto);
    void deletePatient(Long id);
}