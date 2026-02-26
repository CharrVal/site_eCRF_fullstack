package com.example.crf.service;

import com.example.crf.entity.Visit;
import com.example.crf.repositories.VisitRepository;
import com.example.crf.service.Exception.VisitServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository repository;

    public VisitServiceImpl(VisitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Visit findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new VisitServiceException("Visit not found with id:" + id));
    }

    @Override
    public List<Visit> findAllL() {
        return repository.findAll();
    }

    @Override
    public Visit createVisit(Visit visit) {
        return repository.save(visit);
    }

    @Override
    public Visit updateVisit(Long id, Visit visit) {
        Visit visitExisting = repository.findById(id)
                .orElseThrow(() -> new VisitServiceException("Visit not found with id:" + id));
        visitExisting.setDate(visit.getDate());
        visitExisting.setName(visit.getName());
        visitExisting.setVitalSign(visit.getVitalSign());
        return null;
    }

    @Override
    public void deleteVisit(Long id) {
        repository.deleteById(id);
    }
}
