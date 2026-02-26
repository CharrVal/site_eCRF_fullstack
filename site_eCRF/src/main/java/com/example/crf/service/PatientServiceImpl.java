package com.example.crf.service;

import com.example.crf.entity.Patient;
import com.example.crf.repositories.PatientRepository;
import com.example.crf.service.Exception.PatientServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient getPatientById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PatientServiceException("Patient not Found with id : " + id));
    }

    @Override
    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    @Override
    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patientExisting) {
        Patient patient = repository.findById(id)
                .orElseThrow(() -> new PatientServiceException("Patient not Found with id : " + id));
        patient.setVisits(patientExisting.getVisits());
        patient.setSubjectNumber(patientExisting.getSubjectNumber());
        return repository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}
