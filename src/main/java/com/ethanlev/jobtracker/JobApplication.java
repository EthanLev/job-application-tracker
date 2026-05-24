package com.ethanlev.jobtracker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "job_application")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company name is required")
    @Column(name = "company")
    private String company;

    @NotBlank(message = "Job title is required")
    @Column(name = "job_title")
    private String jobTitle;

    @NotBlank(message = "Status is required")
    @Column(name = "status")
    private String status;

    @NotBlank(message = "Date applied is required")
    @Column(name = "date_applied")
    private String dateApplied;

    @Column(name = "notes")
    private String notes;

    // Constructor
    public JobApplication(Long id, String company, String jobTitle,
                          String status, String dateApplied, String notes) {
        this.id = id;
        this.company = company;
        this.jobTitle = jobTitle;
        this.status = status;
        this.dateApplied = dateApplied;
        this.notes = notes;
    }

    public JobApplication() {}

    // Getters
    public Long getId() { return id; }
    public String getCompany() { return company; }
    public String getJobTitle() { return jobTitle; }
    public String getStatus() { return status; }
    public String getDateApplied() { return dateApplied; }
    public String getNotes() { return notes; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setCompany(String company) { this.company = company; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public void setStatus(String status) { this.status = status; }
    public void setDateApplied(String dateApplied) { this.dateApplied = dateApplied; }
    public void setNotes(String notes) { this.notes = notes; }
}
