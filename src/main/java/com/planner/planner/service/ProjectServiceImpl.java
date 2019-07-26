package com.planner.planner.service;

import com.planner.planner.entity.Project;
import com.planner.planner.entity.User;
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
    public List<Project> findAllWithTasks(CurrentUser user) {
        List<Project> projects = projectRepo.findAllByUsers(user.getUser());
        projects.forEach(project -> Hibernate.initialize(project.getTasks()));
        return projects;
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project findById(Long id, CurrentUser user) {
        return projectRepo.findByIdAndUsers(id, user.getUser());
    }

    @Override
    public Project findByIdWithTasks(Long id, CurrentUser user) {
        Project project = findById(id, user);
        Hibernate.initialize(project.getTasks());
        return project;
    }

    @Override
    public void delete(Long id) {
        projectRepo.deleteById(id);
    }
}
