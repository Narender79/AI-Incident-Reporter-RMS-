package com.ai.incidentreporter.service;

import com.ai.incidentreporter.model.Incident;
import com.ai.incidentreporter.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // Marks this class as a Spring Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    // Constructor injection
    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    // --- Add a new incident ---
    public Incident addIncident(Incident incident) {
        incident.setStatus("Open"); // Default status
        return incidentRepository.save(incident);
    }

    // --- Get all incidents ---
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    // --- Get incident by ID ---
    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    // --- Update an incident ---
    public Incident updateIncident(Incident incident) {
        return incidentRepository.save(incident); // save() updates if ID exists
    }

    // --- Delete an incident ---
    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }
}
