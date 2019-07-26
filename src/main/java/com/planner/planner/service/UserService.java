package com.planner.planner.service;

import com.planner.planner.entity.Project;
import com.planner.planner.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUserName(String name);
    List<User> findAllWithTasks();
    User findById(Long id);
    void saveUser(User user);
    User findByIdWithTasks(Long id);
}
