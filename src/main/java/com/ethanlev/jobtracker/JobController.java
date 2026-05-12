package com.ethanlev.jobtracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // Returns list of JobApplication objects in JSON
    @GetMapping
    public List<JobApplication> getAllJobs() {
        return jobs;
    }

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
}
