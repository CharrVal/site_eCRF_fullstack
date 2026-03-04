package com.example.crf.service;

import com.example.crf.entity.Visit;

import java.util.List;

public interface VisitService {
    Visit findById(Long id);
    List<Visit> findVisitsByPatient(Long patientId);
    Visit createVisitForPatient(Long patientId, Visit visit);
}
