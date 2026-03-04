package com.example.crf.controller;

import com.example.crf.dto.VisitRequestDTO;
import com.example.crf.dto.VisitResponseDTO;
import com.example.crf.entity.Visit;
import com.example.crf.mapper.VisitMapper;
import com.example.crf.service.VisitServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/patients/{patientId}/visits")
public class PatientVisitController {

    private final VisitServiceImpl visitService;
    private final VisitMapper visitMapper;

    public PatientVisitController(VisitServiceImpl visitService, VisitMapper visitMapper) {
        this.visitService = visitService;
        this.visitMapper = visitMapper;
    }

    @PostMapping
    public VisitResponseDTO createVisit(
            @PathVariable Long patientId,
            @RequestBody VisitRequestDTO dto) {

        Visit visit = visitMapper.toEntity(dto);
        Visit created = visitService.createVisitForPatient(patientId, visit);

        return visitMapper.toResponse(created);
    }

    @GetMapping
    public List<VisitResponseDTO> getVisitsForPatient(@PathVariable Long patientId) {
        return visitService.findVisitsByPatient(patientId).stream()
                .map(visitMapper::toResponse)
                .toList();
    }
}

