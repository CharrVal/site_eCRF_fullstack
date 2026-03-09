package com.example.crf.service;

import com.example.crf.dto.VisitRequestDTO;
import com.example.crf.dto.VisitResponseDTO;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Visit;
import com.example.crf.mapper.VisitMapper;
import com.example.crf.repositories.PatientRepository;
import com.example.crf.repositories.VisitRepository;
import com.example.crf.service.Exception.PatientServiceException;
import com.example.crf.service.Exception.VisitServiceException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository repository;
    private final PatientRepository patientRepository;
    private final VisitMapper visitMapper;

    public VisitServiceImpl(
            VisitRepository repository,
            PatientRepository patientRepository,
            VisitMapper visitMapper) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.visitMapper = visitMapper;
    }

    @Override
    public VisitResponseDTO findById(Long id) {

        Visit visit = repository.findById(id)
                .orElseThrow(() -> new VisitServiceException("Visit not Found with Id:" + id));

        return visitMapper.toResponseDTO(visit);
    }

    @Override
    public List<VisitResponseDTO> findAll() {

        List<Visit> visits = repository.findAll();

        return visits.stream()
                .map(visitMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<VisitResponseDTO> findByPatient(Long patientId) {

        patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientServiceException("Patient not found with Id:" + patientId));

        List<Visit> visits = repository.findByPatientId(patientId);

        return visits.stream()
                .map(visitMapper::toResponseDTO)
                .toList();
    }

    @Override
    public VisitResponseDTO createVisit(VisitRequestDTO dto) {

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new PatientServiceException(
                        "Patient not found with Id:" + dto.getPatientId()));

        Visit visit = visitMapper.toEntity(dto, patient);

        visit = repository.save(visit);

        return visitMapper.toResponseDTO(visit);
    }

    @Override
    public VisitResponseDTO updateVisit(Long id, VisitRequestDTO dto) {

        Visit visit = repository.findById(id)
                .orElseThrow(() -> new VisitServiceException("Visit not found with Id:" + id));

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new PatientServiceException(
                        "Patient not found with Id:" + dto.getPatientId()));

        visit.setName(dto.getName());
        visit.setVisitDate(dto.getVisitDate());
        visit.setPatient(patient);

        visit = repository.save(visit);

        return visitMapper.toResponseDTO(visit);
    }

    @Override
    public void deleteVisit(Long id) {

        Visit visit = repository.findById(id)
                .orElseThrow(() -> new VisitServiceException("Visit not found with Id:" + id));

        repository.delete(visit);
    }
}