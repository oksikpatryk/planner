package com.planner.planner.service;

import com.planner.planner.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    List<Project> findAllWithTasks();
    Project save(Project project);
    Project findById(Long id);
    Project findByIdWithTasks(Long id);
}
