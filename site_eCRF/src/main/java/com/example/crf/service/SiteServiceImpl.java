package com.example.crf.service;

import com.example.crf.dto.SiteRequestDTO;
import com.example.crf.dto.SiteResponseDTO;
import com.example.crf.entity.Site;
import com.example.crf.entity.Study;
import com.example.crf.mapper.SiteMapper;
import com.example.crf.repositories.SiteRepository;
import com.example.crf.repositories.StudyRepository;
import com.example.crf.service.Exception.SiteServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {

    private final SiteRepository repository;
    private final StudyRepository studyRepository;
    private final SiteMapper mapper;

    public SiteServiceImpl(SiteRepository repository, StudyRepository studyRepository,SiteMapper mapper) {
        this.repository = repository;
        this.studyRepository = studyRepository;
        this.mapper = mapper;
    }

    @Override
    public SiteResponseDTO findById(Long id) {
        Site site = repository.findById(id)
                .orElseThrow(() -> new SiteServiceException("Site not Found with Id:" + id));

        return mapper.toResponseDto(site);
    }

    @Override
    public List<SiteResponseDTO> findAll() {
        List<Site> sites = repository.findAll();

        return sites.stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public List<SiteResponseDTO> findByStudyId(Long studyId) {

        return repository.findByStudyId(studyId)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public SiteResponseDTO create(SiteRequestDTO dto) {

        Study study = studyRepository.findById(dto.getStudyId())
                .orElseThrow(() -> new SiteServiceException("Study not found with id: " + dto.getStudyId()));

        Site site = mapper.toEntity(dto);
        site.setStudy(study);

        site = repository.save(site);

        return mapper.toResponseDto(site);
    }

    @Override
    public SiteResponseDTO update(Long id, SiteRequestDTO dto) {

        Site site = repository.findById(id)
                .orElseThrow(() -> new SiteServiceException("Site not found with id: " + id));

        Study study = studyRepository.findById(dto.getStudyId())
                .orElseThrow(() -> new SiteServiceException("Study not found with id: " + dto.getStudyId()));

        site.setName(dto.getName());
        site.setStartDate(dto.getStartDate());
        site.setEndDate(dto.getEndDate());
        site.setStudy(study);

        site = repository.save(site);

        return mapper.toResponseDto(site);
    }

    @Override
    public void deleteSite(Long id) {
        Site site = repository.findById(id)
                .orElseThrow(() -> new SiteServiceException("Site not Found with Id:" + id));

        repository.delete(site);
    }
}
