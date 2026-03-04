package com.example.crf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "vital_signs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VitalSign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private VitalSignType type;

    private Double value;
    private String unit;

    private LocalDateTime measuredAt;

    @ManyToOne
    @JoinColumn(name = "visit_id", nullable = false)
    private Visit visit;
}
