package com.trackease.timesheet.Service;

import com.trackease.timesheet.DTO.TimesheetRequest;
import com.trackease.timesheet.Model.Project;
import com.trackease.timesheet.Model.Timesheet;
import com.trackease.timesheet.Model.TimesheetStatus;
import com.trackease.timesheet.Model.User;
import com.trackease.timesheet.Repository.ProjectRepo;
import com.trackease.timesheet.Repository.TimesheetRepo;
import com.trackease.timesheet.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TimesheetService {

    private final TimesheetRepo timesheetRepo;
    private final ProjectRepo projectRepo;
    private final UserRepo userRepo;

    public Timesheet submit(TimesheetRequest request, String email){
        User user = userRepo.findByEmail(email).orElseThrow();
        Project project = projectRepo.findById(request.getProjectId()).orElseThrow(() -> new RuntimeException("Project not found for ID: " + request.getProjectId()));

        Timesheet ts = Timesheet.builder()
                .user(user)
                .project(project)
                .date(request.getDate())
                .hours(request.getHours())
                .description(request.getDescription())
                .status(TimesheetStatus.PENDING)
                .build();

        return timesheetRepo.save(ts);
    }

    public List<Timesheet> getPending(){
        return timesheetRepo.findByStatus(TimesheetStatus.PENDING);
    }

    public String approve(Long id){
        Timesheet ts = timesheetRepo.findById(id).orElseThrow();
        ts.setStatus(TimesheetStatus.APPROVED);
        timesheetRepo.save(ts);
        return "Approved";
    }

    public String reject(Long id){
        Timesheet ts = timesheetRepo.findById(id).orElseThrow();
        ts.setStatus(TimesheetStatus.REJECTED);
        timesheetRepo.save(ts);
        return "Rejected";
    }

    public List<Timesheet> getUserTimesheets(String email){
        return timesheetRepo.findByUser_Email(email);
    }
}
