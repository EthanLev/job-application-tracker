package com.ethanlev.jobtracker;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobApplicationRepository repository;

    // Spring sees @Autowired and automatically provides a
    // JobApplicationRepository instance — you never call new on it yourself
    @Autowired
    public JobController(JobApplicationRepository repository) {
        this.repository = repository;
    }

    // GET /jobs — fetch all jobs from the database
    @GetMapping
    public List<JobApplication> getAllJobs(@RequestParam(required = false) String status) {
        if (status != null && !status.isBlank()) {
            return repository.findByStatus(status);
        }

        return repository.findAll();
    }

    // GET /jobs/{id} — fetch one job by id
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobById(@PathVariable Long id) {
        Optional<JobApplication> job = repository.findById(id);

        if (job.isPresent()) {
            return ResponseEntity.ok(job.get());
        }

        throw new ResourceNotFoundException("Job application not found with id: " + id);
    }

    // POST /jobs — save a new job to the database
    @PostMapping
    public ResponseEntity<JobApplication> createJob(@Valid @RequestBody JobApplication newJob) {
        // PostgreSQL auto-generates the id — we no longer set it manually
        JobApplication saved = repository.save(newJob);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PUT /jobs/{id} — update an existing job
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateJob(
            @PathVariable Long id,
            @Valid @RequestBody JobApplication updatedJob) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Job application not found with id: " + id);
        }

        // Set the id so repository.save() updates the existing row
        // instead of inserting a new one
        updatedJob.setId(id);
        JobApplication saved = repository.save(updatedJob);
        return ResponseEntity.ok(saved);
    }

    // DELETE /jobs/{id} — delete a job by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Job application not found with id: " + id);
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}