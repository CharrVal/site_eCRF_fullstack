package com.example.crf.controller;

import com.example.crf.dto.VitalSignRequestDTO;
import com.example.crf.dto.VitalSignResponseDTO;
import com.example.crf.service.VitalSignService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vitalSigns")
public class VitalSignController {

    private final VitalSignService vitalSignService;

    public VitalSignController(VitalSignService vitalSignService) {
        this.vitalSignService = vitalSignService;
    }

    @GetMapping
    public ResponseEntity<List<VitalSignResponseDTO>> findAll() {
        return ResponseEntity.ok(vitalSignService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VitalSignResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vitalSignService.findById(id));
    }

    @GetMapping("/visit/{visitId}")
    public ResponseEntity<List<VitalSignResponseDTO>> findByVisit(@PathVariable Long visitId) {
        return ResponseEntity.ok(vitalSignService.findByVisit(visitId));
    }

    @PostMapping
    public ResponseEntity<VitalSignResponseDTO> createVitalSign(@Valid @RequestBody VitalSignRequestDTO dto) {
        return ResponseEntity.ok(vitalSignService.createVitalSign(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VitalSignResponseDTO> updateVitalSign(@PathVariable Long id, @Valid @RequestBody VitalSignRequestDTO dto) {
        return ResponseEntity.ok(vitalSignService.updateVitalSign(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVitalSign(@PathVariable Long id) {
        vitalSignService.deleteVitalSign(id);
        return ResponseEntity.noContent().build();
    }
}
