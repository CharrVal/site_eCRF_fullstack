package com.example.crf.service;

import com.example.crf.dto.PatientRequestDTO;
import com.example.crf.dto.PatientResponseDTO;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Study;
import com.example.crf.mapper.PatientMapper;
import com.example.crf.repositories.PatientRepository;
import com.example.crf.repositories.StudyRepository;
import com.example.crf.service.Exception.PatientServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final StudyRepository studyRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository repository, StudyRepository studyRepository, PatientMapper patientMapper) {
        this.repository = repository;
        this.studyRepository = studyRepository;
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
    public List<PatientResponseDTO> findByStudy(Long studyId) {
        studyRepository.findById(studyId)
                .orElseThrow(() -> new PatientServiceException("Study not found with id " + studyId));
        List<Patient> patients = repository.findByStudyId(studyId);

        return patients.stream()
                .map(patientMapper::toResponseDTO)
                .toList();
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO dto) {
        Study study = studyRepository.findById(dto.getStudyId())
                .orElseThrow(() -> new PatientServiceException("Study not found with id " + dto.getStudyId()));
        Patient patient = patientMapper.toEntity(dto, study);
        patient = repository.save(patient);

        return patientMapper.toResponseDTO(patient);
    }

    @Override
    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO dto) {
        Patient patient = repository.findById(id)
                .orElseThrow(() -> new PatientServiceException("Patient not found with id " + id));
        Study study = studyRepository.findById(dto.getStudyId())
                .orElseThrow(() -> new PatientServiceException("Study not found with id " + dto.getStudyId()));
        patient.setSubjectNumber(dto.getSubjectNumber());
        patient.setStudy(study);
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
