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
        jobs.add(new JobApplication(
                1L,
                "Google",
                "Software Engineer",
                "APPLIED",
                "05/12/2026",
                "Indeed"
        ));

        jobs.add(new JobApplication(
                2L,
                "Amazon",
                "Software Developer",
                "INTERVIEWED",
                "05/10/2026",
                "LinkedIn"
        ));
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
}
