package com.trackease.timesheet.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TimesheetRequest {
    private Long projectId;
    private LocalDate date;
    private double hours;
    private String description;
}
