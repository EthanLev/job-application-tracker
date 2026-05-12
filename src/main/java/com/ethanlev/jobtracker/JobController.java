package com.ethanlev.jobtracker;

import org.springframework.web.bind.annotation.GetMapping;
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
    }

    // Returns list of JobApplication objects in JSON
    @GetMapping
    public List<JobApplication> getAllJobs() {
        return jobs;
    }
}
