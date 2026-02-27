package com.example.crf.controller;

import com.example.crf.entity.Study;
import com.example.crf.service.StudyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/studies")
public class StudyController {

    private final StudyServiceImpl service;

    public StudyController(StudyServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Study> getStudies() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Study getStudy(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Study addStudy(@RequestBody Study study) {
        return service.createStudy(study);
    }

    @PutMapping("/{id}")
    public Study updateStudy(@PathVariable Long id, @RequestBody Study study) {
        return service.updateStudy(id, study);
    }

    @DeleteMapping("/{id}")
    public void deleteStudy(@PathVariable Long id) {
        service.deleteStudy(id);
    }

}
