package com.example.crf.service;

import com.example.crf.dto.SiteRequestDTO;
import com.example.crf.dto.SiteResponseDTO;

import java.util.List;

public interface SiteService {
    SiteResponseDTO findById(Long id);
    List<SiteResponseDTO> findAll();
    List<SiteResponseDTO> findByStudyId(Long studyId);
    SiteResponseDTO createSite(SiteRequestDTO dto);
    SiteResponseDTO updateSite(Long id, SiteRequestDTO dto);
    void deleteSite(Long id);
}
