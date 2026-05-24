package com.ethanlev.jobtracker;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String msg;

    // List of specific field errors
    private List<String> errors;

    public ErrorResponse(int status, String msg, List<String> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.msg = msg;
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getMessage() { return msg; }
    public List<String> getErrors() { return errors; }
}
