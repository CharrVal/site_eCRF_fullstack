package com.example.crf.controller;

import com.example.crf.dto.SiteRequestDTO;
import com.example.crf.dto.SiteResponseDTO;
import com.example.crf.service.SiteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sites")
public class SiteController {

    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping
    public ResponseEntity<List<SiteResponseDTO>> findAll() {
        return ResponseEntity.ok(siteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiteResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(siteService.findById(id));
    }

    @GetMapping("/study/{studyId}")
    public ResponseEntity<List<SiteResponseDTO>> findByStudyId(@PathVariable Long studyId) {
        return ResponseEntity.ok(siteService.findByStudyId(studyId));
    }

    @PostMapping
    public ResponseEntity<SiteResponseDTO> createSite(@Valid @RequestBody SiteRequestDTO dto) {
        SiteResponseDTO site = siteService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(site);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SiteResponseDTO> updateSite(
            @PathVariable Long id,
            @Valid @RequestBody SiteRequestDTO dto) {

        return ResponseEntity.ok(siteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable Long id) {
        siteService.deleteSite(id);
        return ResponseEntity.noContent().build();
    }
}
