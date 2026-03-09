package com.example.crf.service;

import com.example.crf.dto.VitalSignRequestDTO;
import com.example.crf.dto.VitalSignResponseDTO;
import com.example.crf.entity.Visit;
import com.example.crf.entity.VitalSign;
import com.example.crf.mapper.VitalSignMapper;
import com.example.crf.repositories.VisitRepository;
import com.example.crf.repositories.VitalSignRepository;
import com.example.crf.service.Exception.VitalSignServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitalSignServiceImpl implements VitalSignService {

    private final VitalSignRepository repository;
    private final VisitRepository visitRepository;
    private final VitalSignMapper vitalSignMapper;

    public VitalSignServiceImpl(VitalSignRepository repository, VisitRepository visitRepository, VitalSignMapper vitalSignMapper) {
        this.repository = repository;
        this.visitRepository = visitRepository;
        this.vitalSignMapper = vitalSignMapper;
    }

    @Override
    public VitalSignResponseDTO findById(Long id) {
        VitalSign vitalSign = repository.findById(id)
                .orElseThrow(() -> new VitalSignServiceException("Vital Sign not found with Id:" + id));

        return vitalSignMapper.toResponseDTO(vitalSign);
    }

    @Override
    public List<VitalSignResponseDTO> findAll() {
        List<VitalSign> vitalSigns = repository.findAll();

        return vitalSigns.stream()
                .map(vitalSignMapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<VitalSignResponseDTO> findByVisit(Long visitId) {

        visitRepository.findById(visitId)
                .orElseThrow(() -> new VitalSignServiceException("Visit not found with Id:" + visitId));

        List<VitalSign> vitalSigns = repository.findByVisitId(visitId);

        return vitalSigns.stream()
                .map(vitalSignMapper::toResponseDTO)
                .toList();
    }

    @Override
    public VitalSignResponseDTO createVitalSign(VitalSignRequestDTO dto) {
        Visit visit = visitRepository.findById(dto.getVisitId())
                .orElseThrow(() -> new VitalSignServiceException("Visit not found with Id:" + dto.getVisitId()));

        VitalSign vitalSign = vitalSignMapper.toEntity(dto, visit);
        vitalSign = repository.save(vitalSign);

        return vitalSignMapper.toResponseDTO(vitalSign);
    }

    @Override
    public VitalSignResponseDTO updateVitalSign(Long id, VitalSignRequestDTO dto) {

        VitalSign vitalSign = repository.findById(id)
                .orElseThrow(() -> new VitalSignServiceException("VitalSign not found with Id:" + id));

        Visit visit = visitRepository.findById(dto.getVisitId())
                .orElseThrow(() -> new VitalSignServiceException("Visit not found with Id:" + dto.getVisitId()));

        vitalSign.setType(dto.getType());
        vitalSign.setUnit(dto.getUnit());
        vitalSign.setValue(dto.getValue());
        vitalSign.setMeasuredAt(dto.getMeasuredAt());
        vitalSign.setVisit(visit);
        vitalSign = repository.save(vitalSign);

        return vitalSignMapper.toResponseDTO(vitalSign);
    }

    @Override
    public void deleteVitalSign(Long id) {
        VitalSign vitalSign = repository.findById(id)
                .orElseThrow(() -> new VitalSignServiceException("Vital Sign not found with Id:" + id));
        repository.delete(vitalSign);
    }
}
