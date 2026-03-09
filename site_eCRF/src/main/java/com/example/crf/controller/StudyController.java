package com.example.crf.controller;

import com.example.crf.dto.StudyRequestDTO;
import com.example.crf.dto.StudyResponseDTO;
import com.example.crf.service.StudyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/studies")
public class StudyController {

    private final StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studyService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudyResponseDTO>> findAll() {
        return ResponseEntity.ok(studyService.findAll());
    }

    @PostMapping
    public ResponseEntity<StudyResponseDTO> createStudy(@Valid @RequestBody StudyRequestDTO dto) {
        return ResponseEntity.ok(studyService.createStudy(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyResponseDTO> updateStudy(@PathVariable Long id,@Valid @RequestBody StudyRequestDTO dto) {
        return ResponseEntity.ok(studyService.updateStudy(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudy(@PathVariable Long id) {
        studyService.deleteStudy(id);
        return ResponseEntity.noContent().build();
    }
}
