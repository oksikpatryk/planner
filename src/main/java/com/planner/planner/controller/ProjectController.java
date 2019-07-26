package com.planner.planner.controller;

import com.planner.planner.entity.Project;
import com.planner.planner.entity.Task;
import com.planner.planner.entity.User;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class ProjectController {
    private ProjectService projectService;
    private UserService userService;
    private TaskService taskService;

    @Autowired
    public ProjectController(ProjectService projectService, UserService userService, TaskService taskService) {
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


    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable Long id){
        projectService.delete(id);
        return "redirect:/tasks/";
    }

    @GetMapping("/addProject")
    public String addProject(Model model) {
        model.addAttribute("project", new Project());
        return "addProject";
    }

    @GetMapping("/renameProject/{id}")
    public String renameProject(Model model, @PathVariable Long id, @AuthenticationPrincipal CurrentUser user) {
        model.addAttribute("project", projectService.findById(id, user));
        model.addAttribute("action", "/tasks/addProject");
        return "addProject";
    }

    @PostMapping("/addProject")
    public String addProject(@Valid Project project, BindingResult result, @AuthenticationPrincipal CurrentUser user) {
        if (result.hasErrors()) {
            return "addProject";
        }
        List<User> users = new ArrayList<>();
        users.add(user.getUser());
        project.setUsers(users);
        Project saved = projectService.save(project);
        return "redirect:/tasks/project/" + saved.getId();
    }

    @RequestMapping("/project/{id}")
    public String project(@PathVariable Long id, Model model, @AuthenticationPrincipal CurrentUser user) {
        Project project = projectService.findByIdWithTasks(id, user);
        model.addAttribute("project", project);
        return "project";
    }
}
