package com.trackease.timesheet.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Timesheet {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;
    @ManyToOne
    private Project project;

    private LocalDate date;
    private String description;
    private double hours;

    @Enumerated(EnumType.STRING)
    private TimesheetStatus status;
}
