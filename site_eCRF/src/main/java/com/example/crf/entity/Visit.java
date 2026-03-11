package com.example.crf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "study_id", nullable = false)
    private Study study;

    @OneToMany(
            mappedBy = "visit",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<VitalSign> vitalSigns = new ArrayList<>();
}
