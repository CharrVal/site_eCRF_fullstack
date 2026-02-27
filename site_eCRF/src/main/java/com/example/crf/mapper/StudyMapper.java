package com.example.crf.mapper;

import com.example.crf.dto.*;
import com.example.crf.entity.Patient;
import com.example.crf.entity.Study;

import java.util.List;

public class StudyMapper {

    public Study toEntity(StudyRequestDTO dto) {
        Study study = new Study();

        study.setName(dto.getName());
        study.setDescription(dto.getDescription());

        List<Patient> patients = dto.getPatients().stream()
                .map( patientDTO -> {
                    Patient patient = new Patient();
                    patient.setSubjectNumber(patientDTO.getSubjectNumber());
                    patient.setVisits(patientDTO.getVisitIds());
                    return patient;
                })
                .toList();
        study.setPatients(patients);
        return study;
    }

    public StudyResponseDTO toResponse(Study study) {
        StudyResponseDTO dto = new StudyResponseDTO();

        dto.setId(study.getId());
        dto.setName(study.getName());
        dto.setDescription(study.getDescription());

        List<PatientResponseDTO> patientsDTO = study.getPatients().stream()
                .map(patient -> {
                    PatientResponseDTO patientDTO = new PatientResponseDTO();
                    patientDTO.setSubjectNumber(patient.getSubjectNumber());
                    patientDTO.setVisitIds(patient.getVisits().stream().map(
                            visit -> {
                                VisitResponseDTO visitDTO = new VisitResponseDTO();
                                visit.setName(visitDTO.getName());
                                visit.setDate(visitDTO.getDate());
                                visit.setVitalSign(visitDTO.getVitalSign().stream().map(
                                        vital_sign -> {
                                            VitalSignResponseDTO vitalSignDTO = new VitalSignResponseDTO();
                                            vital_sign.setName(vitalSignDTO.getName());
                                            vital_sign.setPulse(vitalSignDTO.getPulse());
                                            vital_sign.setTemperature(vitalSignDTO.getTemperature());
                                            vital_sign.setsystolicPressure(vitalSignDTO.getSystolicPressure());
                                            vital_sign.diastolicPressure(vitalSignDTO.getDiastolicPressure());
                                            vital_sign.weight(vitalSignDTO.getWeight());
                                            vital_sign.height(vitalSignDTO.getHeight());
                                            return vital_sign;
                                        }
                                ).toList());
                            return visit;
                            }
                    ).toList());
                    return patient;
                }
                .toList());
                return patientsDTO;
        dto.setPatients(patientsDTO);
        return dto;
    }
}
