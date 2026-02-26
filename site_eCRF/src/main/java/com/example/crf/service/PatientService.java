package com.example.crf.service;

import com.example.crf.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    Patient createPatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}
