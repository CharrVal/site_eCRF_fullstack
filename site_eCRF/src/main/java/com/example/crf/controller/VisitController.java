package com.example.crf.controller;

import com.example.crf.dto.VisitRequestDTO;
import com.example.crf.dto.VisitResponseDTO;
import com.example.crf.service.VisitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public ResponseEntity<List<VisitResponseDTO>> findAll() {
        return ResponseEntity.ok(visitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(visitService.findById(id));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<VisitResponseDTO>> findByPatientId(@PathVariable Long patientId) {
        return ResponseEntity.ok(visitService.findByPatient(patientId));
    }

    @PostMapping
    public ResponseEntity<VisitResponseDTO> createVisit(@Valid @RequestBody VisitRequestDTO dto) {
        return ResponseEntity.ok(visitService.createVisit(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitResponseDTO> updateVisit(@PathVariable Long id, @Valid @RequestBody VisitRequestDTO dto) {
        return ResponseEntity.ok(visitService.updateVisit(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}