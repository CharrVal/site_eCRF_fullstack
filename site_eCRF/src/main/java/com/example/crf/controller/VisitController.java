package com.example.crf.controller;

import com.example.crf.dto.VisitResponseDTO;
import com.example.crf.entity.Visit;
import com.example.crf.mapper.VisitMapper;
import com.example.crf.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;
    private final VisitMapper visitMapper;

    public VisitController(VisitService visitService, VisitMapper visitMapper) {
        this.visitService = visitService;
        this.visitMapper = visitMapper;
    }

    @GetMapping("/{id}")
    public VisitResponseDTO getVisitById(@PathVariable Long id) {
        Visit visit = visitService.findById(id);
        return visitMapper.toResponse(visit);
    }
}