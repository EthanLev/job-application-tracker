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

    @NotBlank(message = "Job location is required")
    @Column(name = "location")
    private String location;

    @NotBlank(message = "Status is required")
    @Column(name = "status")
    private String status;

    @NotBlank(message = "Date applied is required")
    @Column(name = "date_applied")
    private String dateApplied;

    @Column(name = "connection")
    private String connection;

    @Column(name = "link")
    private String link;

    @Column(name = "notes")
    private String notes;

    // Constructor
    public JobApplication(Long id, String company, String jobTitle, String location,
                          String status, String dateApplied, String connection, String link, String notes) {
        this.id = id;
        this.company = company;
        this.jobTitle = jobTitle;
        this.location = location;
        this.status = status;
        this.dateApplied = dateApplied;
        this.connection = connection;
        this.link = link;
        this.notes = notes;
    }

    public JobApplication() {}

    // Getters
    public Long getId() { return id; }
    public String getCompany() { return company; }
    public String getJobTitle() { return jobTitle; }
    public String getLocation() { return location; }
    public String getStatus() { return status; }
    public String getDateApplied() { return dateApplied; }
    public String getConnection() { return connection; }
    public String getLink() { return link; }
    public String getNotes() { return notes; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setCompany(String company) { this.company = company; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public void setLocation(String location) { this.location = location; }
    public void setStatus(String status) { this.status = status; }
    public void setDateApplied(String dateApplied) { this.dateApplied = dateApplied; }
    public void setConnection(String connection) { this.connection = connection; }
    public void setLink(String link) { this.link = link; }
    public void setNotes(String notes) { this.notes = notes; }
}
