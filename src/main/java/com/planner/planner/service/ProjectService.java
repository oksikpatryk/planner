package com.planner.planner.service;

import com.planner.planner.entity.Project;
import com.planner.planner.entity.User;

import java.util.List;

public interface ProjectService {
    List<Project> findAllWithTasks(CurrentUser user);
    Project save(Project project);
    Project findById(Long id, CurrentUser user);
    Project findByIdWithTasks(Long id, CurrentUser user);

    void delete(Long id);
}
