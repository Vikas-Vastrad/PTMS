package com.trackease.timesheet.Repository;

import com.trackease.timesheet.Model.Timesheet;
import com.trackease.timesheet.Model.TimesheetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimesheetRepo extends JpaRepository<Timesheet, Long> {
    List<Timesheet> findByUser_Email(String email);
    List<Timesheet> findByStatus(TimesheetStatus status);
}
