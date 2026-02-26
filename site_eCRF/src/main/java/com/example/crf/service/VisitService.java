package com.example.crf.service;

import com.example.crf.entity.Visit;

import java.util.List;

public interface VisitService {
    Visit findById(Long id);
    List<Visit> findAllL();
    Visit createVisit(Visit visit);
    Visit updateVisit(Long id, Visit visit);
    void deleteVisit(Long id);
}
