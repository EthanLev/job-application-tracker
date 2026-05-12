package com.ethanlev.jobtracker;

public class JobApplication {
    private Long id;
    private String company;
    private String jobTitle;
    private String status;
    private String dateApplied;
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
