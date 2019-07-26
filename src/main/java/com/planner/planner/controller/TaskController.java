package com.planner.planner.controller;

import com.planner.planner.entity.Project;
import com.planner.planner.entity.Task;
import com.planner.planner.service.CurrentUser;
import com.planner.planner.service.ProjectService;
import com.planner.planner.service.TaskService;
import com.planner.planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private ProjectService projectService;
    private UserService userService;
    private TaskService taskService;

    @Autowired
    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @ModelAttribute("projects")
    public List<Project> projectList(@AuthenticationPrincipal CurrentUser user) {
        return projectService.findAllWithTasks(user);
    }

    @ModelAttribute("todayTasks")
    public List<Task> todayTasks(@AuthenticationPrincipal CurrentUser user) {
        return taskService.findAllTaskWithIntervalInDaysOrderByPriority(0, user);
    }

    @ModelAttribute("overdueTasks")
    public List<Task> overdueTasks(@AuthenticationPrincipal CurrentUser user) {
        return taskService.findAllOverdueTasks(user);
    }

    @ModelAttribute("tomorrow")
    public String tomorrow() {
        return LocalDate.now().plusDays(1).toString();
    }


    @PostMapping("/searchedTask")
    public String searchedTask(@RequestParam String searchedTask, Model model, @AuthenticationPrincipal CurrentUser user) {
        model.addAttribute("searchedTasks", taskService.findAllByNameContaining(searchedTask, user));
        return "searchedTask";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/tasks/";
    }

    @GetMapping("")
    public String today() {
        return "today";
    }

    @RequestMapping("/task/{id}")
    public String task(@PathVariable Long id) {
        return "task";
    }

    @RequestMapping("/nextSevenDays")
    public String nextWeek() {
        return "nextSevenDays";
    }

    @GetMapping("/addTask")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @PostMapping("/addTask")
    public String addTask(@Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "addTask";
        }
        taskService.save(task);
        return "redirect:/tasks/project/" + task.getProject().getId();
    }
}
