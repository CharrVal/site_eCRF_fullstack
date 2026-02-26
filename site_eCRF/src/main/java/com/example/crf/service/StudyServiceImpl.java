package com.example.crf.service;

import com.example.crf.entity.Study;
import com.example.crf.repositories.StudyRepository;
import com.example.crf.service.Exception.StudyServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {

    private final StudyRepository repository;

    public StudyServiceImpl(StudyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Study findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudyServiceException("Study Not Found with id: :" + id));
    }

    @Override
    public List<Study> findAll() {
        return repository.findAll();
    }

    @Override
    public Study createStudy(Study study) {
        return repository.save(study);
    }

    @Override
    public Study updateStudy(Long id, Study studyExisting) {
        Study study = repository.findById(id)
                .orElseThrow(() -> new StudyServiceException("Study Not Found with id :" + id));
        study.setName(studyExisting.getName());
        study.setDescription(studyExisting.getDescription());

        return repository.save(study);
    }

    @Override
    public void deleteStudy(Long id) {
        repository.deleteById(id);
    }
}
