package com.example.crf.service;

import com.example.crf.dto.StudyRequestDTO;
import com.example.crf.dto.StudyResponseDTO;
import com.example.crf.entity.Site;
import com.example.crf.entity.Study;
import com.example.crf.entity.User;
import com.example.crf.mapper.StudyMapper;
import com.example.crf.repositories.SiteRepository;
import com.example.crf.repositories.StudyRepository;
import com.example.crf.repositories.UserRepository;
import com.example.crf.service.Exception.StudyServiceException;
import com.example.crf.service.Exception.UserServiceException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {

    private final StudyRepository repository;
    private final UserRepository userRepository;
    private final SiteRepository siteRepository;
    private final StudyMapper studyMapper;

    public StudyServiceImpl(StudyRepository repository, UserRepository userRepository, SiteRepository siteRepository, StudyMapper studyMapper) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.siteRepository = siteRepository;
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

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserServiceException("User not found with id:" + dto.getUserId()));

        List<Site> sites = siteRepository.findAllById(dto.getSiteIds());

        study.setUser(user);
        study.setSites(sites);

        Study savedStudy = repository.save(study);

        return studyMapper.toResponseDTO(savedStudy);
    }

    @Override
    public StudyResponseDTO updateStudy(Long id, StudyRequestDTO dto) {

        Study study = repository.findById(id)
                .orElseThrow(() -> new StudyServiceException("Study not found with id:" + id));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserServiceException("User not found with id:" + dto.getUserId()));

        List<Site> sites = siteRepository.findAllById(dto.getSiteIds());

        study.setName(dto.getName());
        study.setDescription(dto.getDescription());
        study.setUser(user);
        study.setSites(sites);

        return studyMapper.toResponseDTO(repository.save(study));
    }

    @Override
    @Transactional
    public void deleteStudy(Long id) {
        Study study = repository.findById(id)
                .orElseThrow(() -> new StudyServiceException("Study not found with id:" + id));

        repository.delete(study);
    }
}
