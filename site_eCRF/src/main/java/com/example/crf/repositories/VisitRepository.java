package com.example.crf.repositories;

import com.example.crf.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit,Long> {
    List<Visit> findByPatientId(Long patientId);
}
