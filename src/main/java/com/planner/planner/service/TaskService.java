package com.planner.planner.service;

import com.planner.planner.entity.Task;
import com.planner.planner.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    List<Task> findAll();
    List<Task> findAllTaskWithIntervalInDaysOrderByPriority(int intervalInDays, CurrentUser user);
    List<Task> findAllOverdueTasks(CurrentUser user);
    Task save(Task task);
    void delete(Long id);
    Task findById(Long id);
    Task findByIdWithTasks(Long id);
    List<Task> findAllByNameContaining(String searchedTask, CurrentUser user);
}
