package com.ethanlev.jobtracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    // Spring reads this method name and automatically generates:
    // SELECT * FROM job_application WHERE status = ?
    List<JobApplication> findByStatus(String status);

    // SELECT * FROM job_application WHERE location = ?
    //List<JobApplication> findByLocation(String location);
}
