package com.planner.planner.service;

import com.planner.planner.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAll();
    Project save(Project project);
    Optional<Project> findById(Long id);
}
