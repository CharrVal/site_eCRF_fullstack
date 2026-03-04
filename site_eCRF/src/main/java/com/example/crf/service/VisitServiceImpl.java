package com.example.crf.service;

import com.example.crf.entity.Patient;
import com.example.crf.entity.Visit;
import com.example.crf.repositories.PatientRepository;
import com.example.crf.repositories.VisitRepository;
import com.example.crf.service.Exception.VisitServiceException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;

    public VisitServiceImpl(
                VisitRepository visitRepository,
                PatientRepository patientRepository) {
            this.visitRepository = visitRepository;
            this.patientRepository = patientRepository;
        }
    @Override
    public Visit createVisitForPatient(Long patientId, Visit visit) {
        Patient patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new VisitServiceException("Patient not found with id: " + patientId));

        visit.setPatient(patient);
        return visitRepository.save(visit);
    }

    @Override
    public List<Visit> findVisitsByPatient(Long patientId) {
        return visitRepository.findByPatientId(patientId);
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id)
                .orElseThrow(() -> new VisitServiceException("Visit not found with id: " + id));
    }
}