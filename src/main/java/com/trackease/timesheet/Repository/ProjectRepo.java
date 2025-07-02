package com.trackease.timesheet.Repository;

import com.trackease.timesheet.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {

}
