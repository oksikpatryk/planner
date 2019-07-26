package com.planner.planner.service;

import com.planner.planner.entity.Task;
import com.planner.planner.entity.User;
import com.planner.planner.repository.TaskRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public List<Task> findAllTaskWithIntervalInDaysOrderByPriority(int intervalInDays, CurrentUser user) {
        return taskRepo.findAllTaskWithIntervalInDaysOrderByPriority(intervalInDays, user.getUser().getId());
    }

    @Override
    public List<Task> findAllOverdueTasks(CurrentUser user) {
        return taskRepo.findAllByCloseDateAfter(user.getUser().getId());
    }

    @Override
    public Task save(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public Task findByIdWithTasks(Long id) {
        return null;
    }

    @Override
    public List<Task> findAllByNameContaining(String searchedTask, CurrentUser user) {
        return taskRepo.findAllByNameContaining(searchedTask, user.getUser().getId());
    }
}
