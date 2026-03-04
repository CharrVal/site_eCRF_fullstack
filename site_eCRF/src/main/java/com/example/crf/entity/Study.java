package com.example.crf.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(
            mappedBy = "study",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Patient> patients = new ArrayList<>();
}
