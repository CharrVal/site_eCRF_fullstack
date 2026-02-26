package com.example.crf.service;

import com.example.crf.entity.Study;

import java.util.List;

public interface StudyService {
    Study findById(Long id);
    List<Study> findAll();
    Study createStudy(Study study);
    Study updateStudy(Long id, Study study);
    void deleteStudy(Long id);
}
