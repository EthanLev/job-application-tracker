package com.ethanlev.jobtracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private List<JobApplication> jobs = new ArrayList<>();

    public JobController() {

    }

    // GET /jobs
    // Returns list of JobApplication objects in JSON
    @GetMapping
    public List<JobApplication> getAllJobs() {
        return jobs;
    }

    // GET /jobs/{id}
    // Returns JobApplication by ID
    // ID in the URL is dynamic - caller supplies the number
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getJobById(@PathVariable Long id) {
        // Search list for job with corresponding id from URL
        for (JobApplication job : jobs) {
            if (job.getId().equals(id)) {
                return ResponseEntity.ok(job);
            }
        }

        // No match found - return 404 Not Found
        return ResponseEntity.notFound().build();
    }

    // POST /jobs
    // Accepts JSON body, creates a new job, adds it to the jobs list
    @PostMapping
    public ResponseEntity<JobApplication> createJob(@RequestBody JobApplication newJob) {
        // Generate ID based on current list size
        Long newId = (long) (jobs.size() + 1);
        newJob.setId(newId);

        jobs.add(newJob);

        return ResponseEntity.status(HttpStatus.CREATED).body(newJob);
    }

    // PUT /jobs/{id}
    // Finds existing job by id and replaces all its fields
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateJob(@PathVariable Long id, @RequestBody JobApplication updatedJob) {

        for (JobApplication job : jobs) {
            if (job.getId().equals(id)) {

                // Replace all fields with the new values from the request body
                job.setCompany(updatedJob.getCompany());
                job.setJobTitle(updatedJob.getJobTitle());
                job.setStatus(updatedJob.getStatus());
                job.setDateApplied(updatedJob.getDateApplied());
                job.setNotes(updatedJob.getNotes());

                return ResponseEntity.ok(job);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE /jobs/{id}
    // Finds job by id and removes it from list
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        for (JobApplication job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
