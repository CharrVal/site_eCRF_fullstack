package com.example.crf.repositories;

import com.example.crf.entity.VitalSign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VitalSignRepository extends JpaRepository<VitalSign,Long> {
    List<VitalSign> findByVisitId(Long visitId);
}
