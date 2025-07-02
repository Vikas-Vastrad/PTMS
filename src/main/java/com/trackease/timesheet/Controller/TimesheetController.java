package com.trackease.timesheet.Controller;

import com.trackease.timesheet.Model.Timesheet;
import com.trackease.timesheet.Service.TimesheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timesheets")
@RequiredArgsConstructor
public class TimesheetController {

    private final TimesheetService timesheetService;

    @PostMapping
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<Timesheet> submit(@RequestBody TimesheetRequest request, Authentication auth){
        return ResponseEntity.ok(timesheetService.submit(request, auth.getName()));
    }

    @GetMapping("/pending")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<List<Timesheet>> getPending(){
        return ResponseEntity.ok(timesheetService.getPending());
    }

    @PatchMapping("/approve/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<String> approve(@PathVariable Long id){
        return ResponseEntity.ok(timesheetService.approve(id));
    }

    @PatchMapping("/reject/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<String> reject(@PathVariable Long id){
        return ResponseEntity.ok(timesheetService.reject(id));
    }

    @GetMapping("/my")
    public ResponseEntity<List<Timesheet>> myTimesheets(Authentication auth){
        return ResponseEntity.ok(timesheetService.getUserTimesheets(auth.getName()));
    }
}
