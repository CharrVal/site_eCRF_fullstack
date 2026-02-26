package com.example.crf.repositories;

import com.example.crf.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study,Long> {
}
