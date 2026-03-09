package com.example.crf.repositories;

import com.example.crf.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site> findByStudyId(Long studyId);
}
