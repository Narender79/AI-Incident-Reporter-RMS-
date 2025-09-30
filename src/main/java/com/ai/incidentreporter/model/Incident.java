package com.ai.incidentreporter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // Marks this class as a database entity
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    private String title;       // Short title
    private String description; // Detailed description
    private String severity;    // LOW, MEDIUM, HIGH
    private String status;      // Open, In Progress, Resolved

    // --- Default constructor required by JPA ---
    public Incident() {}

    // --- Parameterized constructor ---
    public Incident(String title, String description, String severity, String status) {
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
    }

    // --- Getters and setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
