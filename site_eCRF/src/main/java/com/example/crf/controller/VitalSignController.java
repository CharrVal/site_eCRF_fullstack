package com.example.crf.controller;

import com.example.crf.entity.VitalSign;
import com.example.crf.service.VitalSignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vitals")
public class VitalSignController {

    private final VitalSignService service;

    public VitalSignController(VitalSignService service) {
        this.service = service;
    }

    @GetMapping
    public List<VitalSign> getAllVitalSigns() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VitalSign getVitalSignById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public VitalSign createVitalSign(@RequestBody VitalSign vitalSign) {
        return service.createVitalSign(vitalSign);
    }

    @PutMapping("/{id}")
    public VitalSign updateVitalSign(@PathVariable Long id, @RequestBody VitalSign vitalSign) {
        return service.updateVitalSign(id, vitalSign);
    }

    @DeleteMapping("/{id}")
    public void deleteVitalSign(@PathVariable Long id) {
        service.deleteVitalSign(id);
    }
}

