package com.example.crf.service;

import com.example.crf.dto.StudyRequestDTO;
import com.example.crf.dto.StudyResponseDTO;
import com.example.crf.entity.Study;
import com.example.crf.mapper.StudyMapper;
import com.example.crf.repositories.StudyRepository;
import com.example.crf.service.Exception.StudyServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {

    private final StudyRepository repository;
    private final StudyMapper studyMapper;

    public StudyServiceImpl(StudyRepository repository, StudyMapper studyMapper) {
        this.repository = repository;
        this.studyMapper = studyMapper;
    }

    @Override
    public StudyResponseDTO findById(Long id) {

        Study study = repository.findById(id)
                .orElseThrow(() -> new StudyServiceException("Study not found with id:" + id));

        return studyMapper.toResponseDTO(study);
    }

    @Override
    public List<StudyResponseDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(studyMapper::toResponseDTO)
                .toList();
    }

    @Override
    public StudyResponseDTO createStudy(StudyRequestDTO dto) {

        Study study = studyMapper.toEntity(dto);

        study = repository.save(study);

        return studyMapper.toResponseDTO(study);
    }

    @Override
    public StudyResponseDTO updateStudy(Long id, StudyRequestDTO dto) {

        Study study = repository.findById(id)
                .orElseThrow(() -> new StudyServiceException("Study not found with id:" + id));

        study.setName(dto.getName());
        study.setDescription(dto.getDescription());

        return studyMapper.toResponseDTO(repository.save(study));
    }

    @Override
    public void deleteStudy(Long id) {

        repository.deleteById(id);
    }
}
