package com.ai.incidentreporter.controller;

import com.ai.incidentreporter.model.Incident;
import com.ai.incidentreporter.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController             
@RequestMapping("/api/incidents") // Base URL for all endpoints
public class IncidentController {

    private final IncidentService incidentService;

    @Autowired
    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    // --- Create ---
    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentService.addIncident(incident);
    }

    // --- Read all ---
    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    // --- Read by ID ---
    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
        Optional<Incident> incident = incidentService.getIncidentById(id);
        return incident.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    // --- Update ---
    @PutMapping("/{id}")
    public ResponseEntity<Incident> updateIncident(@PathVariable Long id, @RequestBody Incident incident) {
        incident.setId(id); // ensure the ID is correct
        Incident updated = incidentService.updateIncident(incident);
        return ResponseEntity.ok(updated);
    }

    // --- Delete ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
        return ResponseEntity.noContent().build();
    }
}
