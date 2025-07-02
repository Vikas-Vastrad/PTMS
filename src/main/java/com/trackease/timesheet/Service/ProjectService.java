package com.trackease.timesheet.Service;

import com.trackease.timesheet.Model.Project;
import com.trackease.timesheet.Repository.ProjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepo projectRepo;

    public Project create(Project project){
        return projectRepo.save(project);
    }

    public List<Project> getAll(){
        return projectRepo.findAll();
    }

    public Project getById(Long id){
        return projectRepo.findById(id).orElseThrow();
    }
}
