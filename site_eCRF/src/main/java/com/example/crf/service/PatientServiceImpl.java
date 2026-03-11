package com.example.crf.service;

import com.example.crf.dto.PatientRequestDTO;
import com.example.crf.dto.PatientResponseDTO;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Site;
import com.example.crf.mapper.PatientMapper;
import com.example.crf.repositories.PatientRepository;
import com.example.crf.repositories.SiteRepository;
import com.example.crf.service.Exception.PatientServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final SiteRepository siteRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository repository, SiteRepository siteRepository, PatientMapper patientMapper) {
        this.repository = repository;
        this.siteRepository = siteRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientResponseDTO findById(Long id) {
        Patient patient = repository.findById(id)
                .orElseThrow(() -> new PatientServiceException("Patient not found with id " + id));
        return patientMapper.toResponseDTO(patient);
    }

    @Override
    public List<PatientResponseDTO> findAll() {
        List<Patient> patients = repository.findAll();
        return patients.stream()
                .map(patientMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<PatientResponseDTO> findBySiteId(Long siteId) {
        siteRepository.findById(siteId)
                .orElseThrow(() -> new PatientServiceException("Site not found with id " + siteId));
        List<Patient> patients = repository.findBySiteId(siteId);

        return patients.stream()
                .map(patientMapper::toResponseDTO)
                .toList();
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO dto) {
        Site site = siteRepository.findById(dto.getSiteId())
                .orElseThrow(() -> new PatientServiceException("Study not found with id " + dto.getSiteId()));
        Patient patient = patientMapper.toEntity(dto, site);
        patient = repository.save(patient);

        return patientMapper.toResponseDTO(patient);
    }

    @Override
    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO dto) {
        Patient patient = repository.findById(id)
                .orElseThrow(() -> new PatientServiceException("Patient not found with id " + id));
        Site site = siteRepository.findById(dto.getSiteId())
                .orElseThrow(() -> new PatientServiceException("Study not found with id " + dto.getSiteId()));
        patient.setSubjectNumber(dto.getSubjectNumber());
        patient.setSite(site);

        patient = repository.save(patient);

        return patientMapper.toResponseDTO(patient);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = repository.findById(id)
                .orElseThrow(() -> new PatientServiceException("Patient not found with id " + id));
        repository.delete(patient);
    }
}
