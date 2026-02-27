package com.example.crf.controller;

import com.example.crf.entity.Visit;
import com.example.crf.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService service;

    public VisitController(VisitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Visit> getAllVisits() {
        return service.findAllL();
    }

    @GetMapping("/{id}")
    public Visit getVisitById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Visit createVisit(@RequestBody Visit visit) {
        return service.createVisit(visit);
    }

    @PutMapping("/{id}")
    public Visit updateVisit(@PathVariable Long id, @RequestBody Visit visit) {
        return service.updateVisit(id, visit);
    }

    @DeleteMapping("/{id}")
    public void deleteVisit(@PathVariable Long id) {
        service.deleteVisit(id);
    }

}
