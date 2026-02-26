package com.example.crf.service;

import com.example.crf.entity.VitalSign;

import java.util.List;

public interface VitalSignService {
    VitalSign findById(Long id);
    List<VitalSign> findAll();
    VitalSign createVitalSign(VitalSign vitalSign);
    VitalSign updateVitalSign(Long id, VitalSign vitalSign);
    void deleteVitalSign(Long id);
}
