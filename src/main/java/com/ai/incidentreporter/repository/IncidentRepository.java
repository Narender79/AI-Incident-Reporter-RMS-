package com.ai.incidentreporter.repository;

import com.ai.incidentreporter.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Marks this interface as a Spring Data repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    // No code needed, JpaRepository provides CRUD methods
}
