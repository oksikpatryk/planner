package com.planner.planner.service;

import com.planner.planner.entity.Task;
import com.planner.planner.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    List<Task> findAll();
    List<Task> findAllTaskWithIntervalInDaysOrderByPriority(int intervalInDays);
    List<Task> findAllOverdueTasks();
    Task save(Task task);
    void delete(Long id);
    Task findById(Long id);
    Task findByIdWithTasks(Long id);
    List<Task> findAllByNameContaining(String searchedTask);
}
