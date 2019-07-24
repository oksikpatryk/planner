package com.planner.planner.service;

import com.planner.planner.entity.Project;
import com.planner.planner.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findAllWithTasks();
    User save(User user);
    User findById(Long id);
    User findByIdWithTasks(Long id);
}
