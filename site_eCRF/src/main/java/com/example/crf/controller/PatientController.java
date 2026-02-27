package com.example.crf.controller;

import com.example.crf.entity.Patient;
import com.example.crf.service.PatientServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientServiceImpl service;

    public PatientController(PatientServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Patient> findAll() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable long id) {
        return service.getPatientById(id);
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return service.createPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable long id, @RequestBody Patient patient) {
        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        service.deletePatient(id);
    }
}
