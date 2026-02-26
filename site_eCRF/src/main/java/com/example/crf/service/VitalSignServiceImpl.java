package com.example.crf.service;

import com.example.crf.entity.VitalSign;
import com.example.crf.repositories.VitalSignRepository;
import com.example.crf.service.Exception.VitalSignServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitalSignServiceImpl implements VitalSignService {

    private final VitalSignRepository repository;

    public VitalSignServiceImpl(VitalSignRepository repository) {
        this.repository = repository;
    }

    @Override
    public VitalSign findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new VitalSignServiceException("VitalSign not Found with id :" + id));
    }

    @Override
    public List<VitalSign> findAll() {
        return repository.findAll();
    }

    @Override
    public VitalSign createVitalSign(VitalSign vitalSign) {
        return repository.save(vitalSign);
    }

    @Override
    public VitalSign updateVitalSign(Long id, VitalSign vitalSign) {
        VitalSign vitalSignExisting = repository.findById(id)
                .orElseThrow(() -> new VitalSignServiceException("VitalSign not Found with id :" + id));
        vitalSignExisting.setName(vitalSign.getName());
        vitalSignExisting.setTemperature(vitalSign.getTemperature());
        vitalSignExisting.setDescription(vitalSign.getDescription());
        vitalSignExisting.setPulse(vitalSign.getPulse());
        vitalSignExisting.setHeight(vitalSign.getHeight());
        vitalSignExisting.setWeight(vitalSign.getWeight());
        vitalSignExisting.setDiastolicPressure(vitalSign.getDiastolicPressure());
        vitalSignExisting.setSystolicPressure(vitalSign.getSystolicPressure());

        return repository.save(vitalSignExisting);
    }

    @Override
    public void deleteVitalSign(Long id) {
        repository.deleteById(id);
    }
}
