package com.planner.planner.repository;

import com.planner.planner.entity.Project;
import com.planner.planner.entity.User;
import com.planner.planner.service.CurrentUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {
    List<Project> findAllByUsers(User user);
    Project findByIdAndUsers(Long id, User user);
}
