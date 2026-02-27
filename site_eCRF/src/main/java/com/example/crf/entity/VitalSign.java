package com.example.crf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vital_signs")
public class VitalSign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double temperature;
    private Integer pulse;
    private Integer systolicPressure;
    private Integer diastolicPressure;
    private Double weight;
    private Double height;
}
