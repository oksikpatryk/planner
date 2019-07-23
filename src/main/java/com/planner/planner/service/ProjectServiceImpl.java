package com.planner.planner.service;

import com.planner.planner.entity.Project;
import com.planner.planner.repository.ProjectRepo;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepo projectRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    @Override
    public List<Project> findAllWithTasks() {
        List<Project> projects = findAll();
        projects.forEach(project -> Hibernate.initialize(project.getTasks()));
        return projects;
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public Project findByIdWithTasks(Long id) {
        Project project = findById(id);
        Hibernate.initialize(project.getTasks());
        return project;
    }
}
